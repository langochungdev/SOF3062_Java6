package b3;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Database {
    public static Map<String, Student> map = new HashMap<>();

    static {
        map.put("SV01", new Student("SV01", "Lý Thái Tổ", true, 9.5));
        map.put("SV02", new Student("SV02", "Lê Trọng Tấn", true, 4.5));
        map.put("SV03", new Student("SV03", "Nguyễn Thị Minh Khai", false, 8.5));
        map.put("SV04", new Student("SV04", "Đoàn Trung Trực", true, 6.0));
    }


    public static String getKey() {
        return Integer.toHexString(UUID.randomUUID().toString().hashCode());
    }
}
