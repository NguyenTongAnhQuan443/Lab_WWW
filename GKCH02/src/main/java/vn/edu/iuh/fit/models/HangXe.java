package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "hangXe")
@NamedQueries({
        @NamedQuery(name = "HangXe.deleteByMaHangXe", query = "delete from HangXe h where h.maHangXe = :maHangXe"),
        @NamedQuery(name = "HangXe.findAll", query = "select h from HangXe h")
})
public class HangXe {
    @Id
    @Column(name = "maHangXe", columnDefinition = "VARCHAR(50)")
    private String maHangXe;

    @Column(name = "tenHang", columnDefinition = "VARCHAR(50)")
    private String tenHang;

    @Column(name = "quocGia", columnDefinition = "VARCHAR(50)")
    private String quocGia;

    @Column(name = "moTa", columnDefinition = "VARCHAR(50)")
    private String moTa;

    @OneToMany(mappedBy = "hangXe")
    private Set<Xe> xe;

    public HangXe() {
    }

    public HangXe(String maHangXe, String moTa, String quocGia, String tenHang) {
        this.maHangXe = maHangXe;
        this.moTa = moTa;
        this.quocGia = quocGia;
        this.tenHang = tenHang;
    }

    public String getMaHangXe() {
        return maHangXe;
    }

    public void setMaHangXe(String maHangXe) {
        this.maHangXe = maHangXe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public Set<Xe> getXe() {
        return xe;
    }

    public void setXe(Set<Xe> xe) {
        this.xe = xe;
    }
}
