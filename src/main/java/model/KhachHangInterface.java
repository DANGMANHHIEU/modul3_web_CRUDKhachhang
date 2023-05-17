package model;

import java.util.List;

public interface KhachHangInterface {
    List<KhachHang>findAll();
    KhachHang findById(int id);
    void save(KhachHang khachHang);
    void update(int id, KhachHang khachHang);
    void remove(int id);
}
