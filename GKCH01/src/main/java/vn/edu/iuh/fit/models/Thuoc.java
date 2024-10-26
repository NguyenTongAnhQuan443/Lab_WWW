package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "thuoc")
@NamedQueries({
        @NamedQuery(name = "Thuoc.findAll", query = "select t from Thuoc t"),
        @NamedQuery(name = "Thuoc.findByLoaiThuoc_MaLoai", query = "select t from Thuoc t where t.loaiThuoc.maLoai = :maLoai")
})
public class Thuoc {

    @Id
    @Column(name = "maThuoc", columnDefinition = "VARCHAR(50)")
    private String maThuoc;

    @Column(name = "tenThuoc", columnDefinition = "VARCHAR(50)")
    private String tenThuoc;

    @Column(name = "gia", columnDefinition = "DOUBLE")
    private double gia;

    @Column(name = "namSX", columnDefinition = "INT")
    private int namSX;

//     mot loai thuoc co nhieu thuoc => n - 1
    @ManyToOne
    @JoinColumn(name = "maLoai")
    private LoaiThuoc loaiThuoc;

    public Thuoc() {
    }

    public Thuoc(String maThuoc, String tenThuoc, double gia, int namSX) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.gia = gia;
        this.namSX = namSX;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public LoaiThuoc getLoaiThuoc() {
        return loaiThuoc;
    }

    public void setLoaiThuoc(LoaiThuoc loaiThuoc) {
        this.loaiThuoc = loaiThuoc;
    }
}
