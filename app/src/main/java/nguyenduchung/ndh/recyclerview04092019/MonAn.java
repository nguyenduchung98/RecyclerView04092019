package nguyenduchung.ndh.recyclerview04092019;

public class MonAn {
    private String ten;
    private String mota;
    private Integer gia;
    private Integer hinhanh;

    public MonAn() {
    }

    public MonAn(String ten, String mota, Integer gia, Integer hinhanh) {
        this.ten = ten;
        this.mota = mota;
        this.gia = gia;
        this.hinhanh = hinhanh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public Integer getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(Integer hinhanh) {
        this.hinhanh = hinhanh;
    }
}
