package BaseApp;

import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class NegaraAPI {
    private JComboBox<String> comboNegara;
     private static List<String> cachedNegara = null;
    
    public NegaraAPI(JComboBox<String> comboBox) {
        this.comboNegara = comboBox;
        
        if (cachedNegara != null && !cachedNegara.isEmpty()) {
            loadFromCache();
        } else {
            // Tampilkan loading message
            comboNegara.addItem("Memuat data negara...");
            comboNegara.setEnabled(false);
            
            // Jalankan di background thread
            ambilDataNegaraAsync();
        }
    
       
    }
        private void loadFromCache() {
        comboNegara.removeAllItems();
        comboNegara.addItem("-- Pilih Negara --");
        
        for (String negara : cachedNegara) {
            comboNegara.addItem(negara);
        }
        
        comboNegara.setEnabled(true);
        System.out.println("Data negara dimuat dari cache: " + cachedNegara.size() + " negara");
    }
    
    private void ambilDataNegaraAsync() {
        SwingWorker<List<String>, Void> worker = new SwingWorker<List<String>, Void>() {
            @Override
            protected List<String> doInBackground() throws Exception {
                // Network request di background thread
                List<String> daftarNegara = new ArrayList<>();
                
                URL url = new URL("https://restcountries.com/v3.1/all");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(8000);  // 10 detik
                conn.setReadTimeout(8000);     // 10 detik
                
                // Tambahkan User-Agent untuk menghindari blocking
                conn.setRequestProperty("User-Agent", "Mozilla/5.0");
                
                int responseCode = conn.getResponseCode();
                if (responseCode != 200) {
                    throw new IOException("HTTP error code: " + responseCode);
                }
                
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                conn.disconnect();
                
                // Parse JSON
                JsonArray data = JsonParser.parseString(response.toString()).getAsJsonArray();
                
                for (JsonElement elem : data) {
                    JsonObject obj = elem.getAsJsonObject();
                    
                    String nama = obj.has("name") && !obj.get("name").isJsonNull() 
                        ? obj.get("name").getAsJsonObject().get("common").getAsString() 
                        : "Nama Tidak Diketahui";
                    
                    String kode = "";
                    if (obj.has("idd") && !obj.get("idd").isJsonNull()) {
                        JsonObject idd = obj.get("idd").getAsJsonObject();
                        if (idd.has("root") && !idd.get("root").isJsonNull()) {
                            String root = idd.get("root").getAsString();
                            if (idd.has("suffixes") && !idd.get("suffixes").isJsonNull()) {
                                JsonArray suffixes = idd.get("suffixes").getAsJsonArray();
                                if (suffixes.size() > 0) {
                                    kode = root + suffixes.get(0).getAsString();
                                } else {
                                    kode = root;
                                }
                            } else {
                                kode = root;
                            }
                        }
                    }
                    
                    if (!kode.isEmpty()) {
                        daftarNegara.add(nama + " (" + kode + ")");
                    } else {
                        daftarNegara.add(nama);
                    }
                }
                
                // Urutkan secara alfabet
                Collections.sort(daftarNegara);
                
                return daftarNegara;
            }
            
            @Override
            protected void done() {
                try {
                    List<String> daftarNegara = get();
                    
                    // Bersihkan combo box
                    comboNegara.removeAllItems();
                    
                    // Tambahkan placeholder
                    comboNegara.addItem("-- Pilih Negara --");
                    
                    // Tambahkan data negara
                    for (String negara : daftarNegara) {
                        comboNegara.addItem(negara);
                    }
                    
                    // Enable combo box
                    comboNegara.setEnabled(true);
                    
                    System.out.println("Data negara berhasil dimuat: " + daftarNegara.size() + " negara");
                    
                } catch (Exception e) {
                    // Handle error
                    comboNegara.removeAllItems();
                    comboNegara.addItem("Gagal memuat data");
                    comboNegara.setEnabled(true);
                    
                    System.err.println("Error loading countries: " + e.getMessage());
                    e.printStackTrace();
                    
                    // Tampilkan dialog error (opsional)
                    JOptionPane.showMessageDialog(null, 
                        "Gagal memuat data negara.\nPastikan koneksi internet tersedia.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        
        // Mulai background task
        worker.execute();
    }
}