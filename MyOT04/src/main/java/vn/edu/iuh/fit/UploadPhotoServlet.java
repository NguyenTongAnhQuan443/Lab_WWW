package vn.edu.iuh.fit;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.nio.file.*;

@MultipartConfig
@WebServlet("/UploadPhotoServlet")
public class UploadPhotoServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/upload.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String name = req.getParameter("fullName");
            Part part = req.getPart("photo");

            if (part == null || part.getSubmittedFileName() == null || part.getSubmittedFileName().isEmpty()) {
                throw new RuntimeException("File upload is required.");
            }

            String realPart = req.getServletContext().getRealPath("/images");
            if (realPart == null) {
                throw new RuntimeException("The upload directory path is not available.");
            }

            Path uploadDir = Path.of(realPart);
            if (!Files.exists(uploadDir)) {
                // Tạo thư mục nếu chưa tồn tại
                Files.createDirectories(uploadDir);
            }

            String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();

            // Ghi tệp vào thư mục "realPart"
            part.write(uploadDir.resolve(fileName).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void destroy() {
    }
}