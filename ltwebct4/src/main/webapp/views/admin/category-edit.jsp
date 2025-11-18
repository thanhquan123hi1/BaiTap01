<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập nhật danh mục</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            border: none;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.1);
        }
        /* Header màu cam/vàng để phân biệt với trang Thêm (màu xanh) hoặc giữ màu xanh nếu muốn đồng bộ */
        .card-header {
            background: linear-gradient(45deg, #f6c23e, #fd7e14); /* Gradient cam để báo hiệu là 'Sửa' */
            color: white;
            padding: 1rem 1.5rem;
            font-weight: 600;
        }
        /* Hoặc nếu bạn thích màu xanh đồng bộ thì dùng đoạn dưới đây thay cho đoạn trên */
        /*
        .card-header {
            background: linear-gradient(45deg, #4e73df, #224abe);
        }
        */
        
        .form-label {
            font-weight: 500;
            color: #495057;
        }
        .form-control:focus {
            box-shadow: 0 0 0 0.2rem rgba(253, 126, 20, 0.25); /* Shadow màu cam */
            border-color: #fd7e14;
        }
        .form-icon {
            color: #6c757d;
            width: 20px;
            text-align: center;
            margin-right: 5px;
        }
        .id-badge {
            background-color: rgba(255,255,255,0.2);
            padding: 2px 8px;
            border-radius: 4px;
            font-size: 0.85rem;
            float: right;
        }
    </style>
</head>

<body class="py-5">

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">
                
                <div class="card">
                    <div class="card-header">
                        <span><i class="fa-solid fa-pen-to-square me-2"></i> Cập nhật danh mục</span>
                        <span class="id-badge"><i class="fa-solid fa-hashtag"></i> ID: ${cate.cate_id}</span>
                    </div>

                    <div class="card-body p-4">
                        
                        <form action="${pageContext.request.contextPath}/admin/categories/edit" method="post">

                            <input type="hidden" name="cate_id" value="${cate.cate_id}">

                            <div class="mb-4">
                                <label class="form-label">
                                    <i class="fa-solid fa-tag form-icon"></i>Tên danh mục <span class="text-danger">*</span>
                                </label>
                                <input type="text" 
                                       class="form-control form-control-lg" 
                                       name="cate_name" 
                                       value="${cate.cate_name}" 
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
                                           value="${cate.icons}"
                                           placeholder="Class icon hoặc đường dẫn ảnh">
                                </div>
                                <div class="form-text text-muted small ms-1">
                                    Giá trị hiện tại: <strong>${cate.icons}</strong>
                                </div>
                            </div>

                            <hr class="my-4">

                            <div class="d-flex justify-content-end gap-2">
                                <a href="${pageContext.request.contextPath}/admin/categories" 
                                   class="btn btn-light text-secondary border">
                                    <i class="fa-solid fa-xmark me-1"></i> Hủy bỏ
                                </a>
                                
                                <button type="submit" class="btn btn-warning text-white fw-bold px-4">
                                    <i class="fa-solid fa-check me-1"></i> Cập nhật
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