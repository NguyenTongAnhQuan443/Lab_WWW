package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "xe")
@NamedQueries({
        @NamedQuery(name = "Xe.findAll", query = "select x from Xe x"),
        @NamedQuery(name = "Xe.deleteByMaXe", query = "delete from Xe x where x.maXe = :maXe"),
        @NamedQuery(name = "Xe.findByTenXe", query = "select x from Xe x where x.tenXe = :tenXe"),
        @NamedQuery(name = "Xe.findByGiaXe", query = "select x from Xe x where x.giaXe = :giaXe")
})
public class Xe {
    @Id
    @Column(name = "maXe", columnDefinition = "VARCHAR(50)")
    private String maXe;

    @Column(name = "tenXe", columnDefinition = "VARCHAR(50)")
    private String tenXe;

    @Column(name = "giaXe", columnDefinition = "DOUBLE")
    private double giaXe;

    @Column(name = "namSanXuat", columnDefinition = "INT")
    private int namSanXuat;

    // hang co nhieu xe
    @ManyToOne
    @JoinColumn(name = "maHangXe")
    private HangXe hangXe;

    public Xe() {
    }

    public Xe(double giaXe, String maXe, int namSanXuat, String tenXe) {
        this.giaXe = giaXe;
        this.maXe = maXe;
        this.namSanXuat = namSanXuat;
        this.tenXe = tenXe;
    }

    public double getGiaXe() {
        return giaXe;
    }

    public void setGiaXe(double giaXe) {
        this.giaXe = giaXe;
    }

    public HangXe getHangXe() {
        return hangXe;
    }

    public void setHangXe(HangXe hangXe) {
        this.hangXe = hangXe;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }
}
