package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "loai_thuoc")
@NamedQueries({
        @NamedQuery(name = "LoaiThuoc.findAll", query = "select l from LoaiThuoc l")
})
public class LoaiThuoc {
    @Id
    @Column(name = "maLoai", columnDefinition = "VARCHAR(50)")
    private String maLoai;

    @Column(name = "tenLoai", columnDefinition = "VARCHAR(50)")
    private String tenLoai;

    @OneToMany(mappedBy = "maThuoc")
    private Set<Thuoc> thuoc;

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public LoaiThuoc() {
    }

    public LoaiThuoc(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }
}
