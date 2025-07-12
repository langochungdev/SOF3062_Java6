package b1;

public class RestClient {
    static String host = "https://j6lab4-8bd39-default-rtdb.asia-southeast1.firebasedatabase.app";

    private static void getAll() {
        var url = host + "/students.json";
        try {
            var connection = HttpClient.openConnection("GET", url);
            var response = HttpClient.readData(connection);
            System.out.println(new String(response));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void getByKey() {
        var key = "sv001"; // đổi theo key thật
        var url = host + "/students/" + key + ".json";
        try {
            var connection = HttpClient.openConnection("GET", url);
            var response = HttpClient.readData(connection);
            System.out.println(new String(response));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void post() {
        var url = host + "/students.json";
        var json = """
                {
                    "id": "SV09",
                    "name": "Sinh viên 09",
                    "mark": 5.5,
                    "gender": true
                }
                """;
        var data = json.getBytes();
        try {
            var connection = HttpClient.openConnection("POST", url);
            var response = HttpClient.writeData(connection, data);
            System.out.println(new String(response));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void put() {
        var key = "sv001"; // đổi theo key thật
        var url = host + "/students/" + key + ".json";
        var json = """
                {
                    "id": "SV09",
                    "name": "Sinh viên 09",
                    "mark": 5.5,
                    "gender": true
                }
                """;
        var data = json.getBytes();
        try {
            var connection = HttpClient.openConnection("PUT", url);
            var response = HttpClient.writeData(connection, data);
            System.out.println(new String(response));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void delete() {
        var key = "sv001"; // đổi theo key thật
        var url = host + "/students/" + key + ".json";
        try {
            var connection = HttpClient.openConnection("DELETE", url);
            HttpClient.readData(connection);
            System.out.println("Đã xóa: " + key);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        getAll();
        getByKey();
        post();
        put();
        delete();
    }
}
