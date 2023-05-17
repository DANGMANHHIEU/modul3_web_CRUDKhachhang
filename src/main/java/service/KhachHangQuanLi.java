package service;

import model.KhachHang;
import model.KhachHangInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KhachHangQuanLi implements KhachHangInterface {

    private static Map<Integer,KhachHang> KhachHangs;
    static {
        KhachHangs = new HashMap<>();
        KhachHangs.put(1, new KhachHang(1, "John", "john@codegym.vn", "Hanoi"));
        KhachHangs.put(2, new KhachHang(2, "Bill", "bill@codegym.vn", "Danang"));
        KhachHangs.put(3, new KhachHang(3, "Alex", "alex@codegym.vn", "Saigon"));
        KhachHangs.put(4, new KhachHang(4, "Adam", "adam@codegym.vn", "Beijin"));
        KhachHangs.put(5, new KhachHang(5, "Sophia", "sophia@codegym.vn", "Miami"));
        KhachHangs.put(6, new KhachHang(6, "Rose", "rose@codegym.vn", "Newyork"));
    }
    @Override
    public List<KhachHang> findAll() {
        return new ArrayList<>(KhachHangs.values());
    }

    @Override
    public KhachHang findById(int id) {
        return KhachHangs.get(id);
    }

    @Override
    public void save(KhachHang khachHang) {
         KhachHangs.put(khachHang.getId(),khachHang);
    }

    @Override
    public void update(int id, KhachHang khachHang) {
               KhachHangs.put(id,khachHang);
    }

    @Override
    public void remove(int id) {
      KhachHangs.remove(id);
    }
}
