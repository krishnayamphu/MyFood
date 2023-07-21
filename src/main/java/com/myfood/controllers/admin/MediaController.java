package com.myfood.controllers.admin;

import com.myfood.utils.Media;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "MediaController", value = "/admin/media")
public class MediaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=getServletContext().getRealPath("/uploads");
        ArrayList<String> allFiles= Media.allFiles(path);
        request.setAttribute("allFiles",allFiles);
        request.getRequestDispatcher("media.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List<FileItem> items = upload.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    if (item.isFormField()) {
                        //processFormField(item);
                    } else {
                        String rootPath = getServletContext().getRealPath("/uploads");
                        processUploadedFile(item, rootPath);
                        response.sendRedirect(request.getHeader("referer"));
                    }
                }
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }
        } else {
            pw.println("No upload file were made.");
        }
    }

    private void processUploadedFile(FileItem item, String rootPath) {
        String fileName = item.getName();
        File path = new File(rootPath);
        if (!path.exists()) {
            path.mkdirs();
        }
        File uploadedFile = new File(path + "/" + fileName);
        try {
            item.write(uploadedFile);
            System.out.println("File Uploaded to :" + uploadedFile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
