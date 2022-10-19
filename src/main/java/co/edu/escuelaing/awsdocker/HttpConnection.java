package co.edu.escuelaing.awsdocker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class HttpConnection {

        private static final String USER_AGENT = "Mozilla/5.0";
        private String url = "http://localhost:1234/mongo?cad=";

        /**
         * Realizar conexión a logservice por medio de GET
         * @param valor cadena que se desea ingresar a la base de datos.
         * @return últimos 10 registros de la base de datos.
         * @throws IOException
         */
        public String mongodb(String valor) throws IOException, IOException {
            System.out.println("entra a http de round robin");
            String site = url+valor;
            URL obj = new URL(site);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            //The following invocation perform the connection implicitly before getting the code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
                return response.toString();
            }else {
                System.out.println("GET request not worked");
            }

            System.out.println("GET DONE");
            return "(Error)";

        }

}
