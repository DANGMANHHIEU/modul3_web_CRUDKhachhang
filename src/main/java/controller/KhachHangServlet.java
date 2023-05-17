package controller;

import model.KhachHang;
import service.KhachHangQuanLi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@WebServlet(name="KhachHangServlet", value = "/khachhang")
public class KhachHangServlet extends HttpServlet {
      private KhachHangQuanLi DanhSachKhacHang = new KhachHangQuanLi();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action= req.getParameter("action");
        if(action== null){
            action="";
        }
        switch (action){
            case "create":
                ThemMoi(req,resp);
                break;
            case "edit":
                Sua(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            case "view":
                break;
            default:
                DanhSach(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action= req.getParameter("action");
        if(action== null){
            action="";
        }
        switch (action){
            case "create":
               LuuThemMoi(req,resp);
                break;
            case "edit":
                LuuSua(req,resp);
                break;
            case "delete":
                deleteKH(req,resp);
                break;
            default:
                break;
        }
    }
    private void DanhSach(HttpServletRequest req, HttpServletResponse resp){
        List<KhachHang> DSach = DanhSachKhacHang.findAll();
        req.setAttribute("khachhang",DSach);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("danhsach.jsp");
        try{
            requestDispatcher.forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void ThemMoi(HttpServletRequest req, HttpServletResponse resp){
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("themmoi.jsp");
        try{
            requestDispatcher.forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void LuuThemMoi(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
      String name = req.getParameter("name");
      String email = req.getParameter("email");
      String address = req.getParameter("address");
      int id = (int) (Math.random() * 10000);

      KhachHang khachHang = new KhachHang(id,name,email,address);
      DanhSachKhacHang.save(khachHang);
      RequestDispatcher requestDispatcher = req.getRequestDispatcher("themmoi.jsp");
      req.setAttribute("message","Lưu lại thành công!!!");
      try{
          requestDispatcher.forward(req,resp);
      }catch (Exception e){
          e.printStackTrace();
      }
    }
    private void Sua(HttpServletRequest req, HttpServletResponse resp){
        int id=Integer.parseInt(req.getParameter("id"));
        KhachHang khachHang= DanhSachKhacHang.findById(id);
        RequestDispatcher dispatcher;
        if (khachHang == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        }
        else {
            req.setAttribute("khachhang",khachHang);
            dispatcher=req.getRequestDispatcher("Sua.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void LuuSua(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        KhachHang khachHang = DanhSachKhacHang.findById(id);
        RequestDispatcher dispatcher;
        if(khachHang == null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        }
        else {
            khachHang.setName(name);
            khachHang.setEmail(email);
            khachHang.setAddress(address);
            this.DanhSachKhacHang.update(id,khachHang);
            req.setAttribute("khachhang",khachHang);
            req.setAttribute("message","Cập nhập thành công!!!");
            dispatcher=req.getRequestDispatcher("Sua.jsp");
        }
        try{
            dispatcher.forward(req,resp);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        KhachHang khachHang = DanhSachKhacHang.findById(id);
        RequestDispatcher dispatcher;
        if(khachHang == null){
            dispatcher = req.getRequestDispatcher("errnor-404.jsp");
        }
        else {
            req.setAttribute("khachhang",khachHang);
            dispatcher= req.getRequestDispatcher("delete.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private void deleteKH(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        KhachHang khachHang = DanhSachKhacHang.findById(id);
        RequestDispatcher dispatcher;
        if(khachHang == null){
            dispatcher= req.getRequestDispatcher("error-404.jsp");
        }
        else {
            DanhSachKhacHang.remove(id);
        }
        try{
            resp.sendRedirect("/khachhang");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
