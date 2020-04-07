# DeviceManagementWeb
Project: Create simple web DeviceManagement
# QUẢN LÝ THIẾT BỊ
## Đặc tả thiết bị:
o	ID <br/>
o	Tên thiết bị <br/>
o	Mô tả thiết bị<br/>
o	Loại thiết bị<br/>
o	Vị trí:<br/>
  	Thiết bị đang ở phòng nào<br/>
  	Thông tin về lịch sử vị trí (đã từng ở phòng nào tại thời điểm nào)<br/>
  	Chuyển thiết bị qua vị trí khác phải ghi nhận user chuyển, thời điểm chuyển, lý do chuyển<br/>
o	Image<br/>
o	Ngày mua<br/>
o	Thời gian bảo hành<br/>
o	Số lần sửa chữa<br/>
o	Mỗi lần sửa chữa <br/>
  	Ghi nhận lại nội dung yêu cầu<br/>
  	User nào yêu cầu<br/>
  	Thời gian yêu cầu<br/>
  	Ghi nhận lại nội dung sửa chữa<br/>
  	User nào nhận sửa chữa<br/>
  	Thời gian bắt đầu/kết thúc sửa chữa<br/>
  	Kết quả sửa chữa<br/>
o	Trạng thái thiết bị<br/>
-	Người dùng:<br/>
o	Thiết bị:<br/>
  	Thông báo thiết bị cần sửa chữa (với thiết bị thuộc phòng mình đang làm việc)<br/>
  	Nhận thông báo khi yêu cầu sửa chữa của mình được xử lý/hoàn tất/hủy bỏ<br/>
-	Nhân viên sửa chữa:<br/>
o	Nhận thông báo khi có người dùng gửi thông báo sửa chữa thiết bị<br/>
o	Search thiết bị để cập nhật <br/>
  	Đổi vị trí<br/>
  	Ghi nhận nội dung sửa chữa thiết bị<br/>
  	Xem được lịch sử của thiết bị<br/>
-	Admin:<br/>
o	CRUD người dùng/nhân viên sửa chữa<br/>
o	CRUD thiết bị<br/>
o	CRUD phòng<br/>
o	Add thiết bị/người dùng vào phòng tương ứng<br/>
o	Nhận thông báo khi có người dùng gửi thông báo sửa chữa thiết bị<br/>
o	Lịch sử sửa chữa của thiết bị:<br/>
  	Thời điểm yêu cầu<br/>
  	Nội dung yêu cầu<br/>
  	Người gửi<br/>
  	Thời điểm kết thúc<br/>
  	Nội dung sửa chữa<br/>
  	Kết quả sửa chữa<br/>
  	Người sửa chữa<br/>
o	Thống kê thiết bị:<br/>
  	Theo trạng thái + thời gian (from - to)<br/>
  	Theo số lần sửa chữa<br/>

-	Phải có login/logout<br/>
-	Phải có thông tin người sửa chữa cập nhật (ai cập nhật, thời điểm cập nhật)<br/>
-	Có thông báo cho tất cả các user khi có cập nhật hệ thống có liên quan đến user đó.<br/>
-	Sử dụng database: MS SQL Server <br/>
-	Tất cả các new ideas đều phải được xác nhận bằng email<br/>

Trạng thái thiết bị: đang sử dụng, đang sửa chữa, bị hư, đã xoá 
