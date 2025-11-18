<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục mới</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <style>
        body {
            background-color: #f8f9fa; /* Màu nền xám đồng bộ */
        }
        .card {
            border: none;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.1); /* Đổ bóng mềm */
            overflow: hidden;
        }
        .card-header {
            background: linear-gradient(45deg, #4e73df, #224abe); /* Gradient xanh */
            color: white;
            padding: 1rem 1.5rem;
            font-weight: 600;
        }
        .form-label {
            font-weight: 500;
            color: #495057;
        }
        .form-control:focus {
            box-shadow: 0 0 0 0.2rem rgba(78, 115, 223, 0.25);
            border-color: #4e73df;
        }
        .form-icon {
            color: #6c757d;
            width: 20px;
            text-align: center;
            margin-right: 5px;
        }
    </style>
</head>

<body class="py-5">

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6"> <div class="card">
                    <div class="card-header">
                        <i class="fa-solid fa-plus-circle me-2"></i> Thêm danh mục mới
                    </div>
                    
                    <div class="card-body p-4">
                        <form action="${pageContext.request.contextPath}/admin/categories/add" method="post">

                            <div class="mb-4">
                                <label class="form-label">
                                    <i class="fa-solid fa-tag form-icon"></i>Tên danh mục <span class="text-danger">*</span>
                                </label>
                                <input type="text" 
                                       class="form-control form-control-lg" 
                                       name="cate_name" 
                                       placeholder="Ví dụ: Điện tử, Thời trang..." 
                                       required>
                            </div>

                            <div class="mb-4">
                                <label class="form-label">
                                    <i class="fa-solid fa-icons form-icon"></i>Icon
                                </label>
                                <div class="input-group">
                                    <span class="input-group-text bg-light"><i class="fa-solid fa-link"></i></span>
                                    <input type="text" 
                                           class="form-control" 
                                           name="icons" 
                                           placeholder="Nhập tên class icon (fa-user) hoặc đường dẫn ảnh">
                                </div>
                                <div class="form-text text-muted small ms-1">
                                    Có thể nhập mã icon FontAwesome hoặc URL hình ảnh.
                                </div>
                            </div>

                            <hr class="my-4">

                            <div class="d-flex justify-content-end gap-2">
                                <a href="${pageContext.request.contextPath}/admin/categories" 
                                   class="btn btn-light text-secondary border">
                                    <i class="fa-solid fa-arrow-left me-1"></i> Quay lại
                                </a>
                                
                                <button type="submit" class="btn btn-primary px-4 fw-bold">
                                    <i class="fa-solid fa-save me-1"></i> Lưu lại
                                </button>
                            </div>

                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>