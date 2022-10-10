Select * from CauHoiTN
SELECT CauHoiTN.TenChuDe
FROM CauHoiTN INNER JOIN ChuDe
ON CauHoiTN.TenChuDe = ChuDe.TenChuDe

SELECT DISTINCT TuVung.TenChuDe
FROM TuVung INNER JOIN ChuDe
ON TuVung.TenChuDe = ChuDe.TenChuDe
WHERE TuVung.MaTV = 'TV001'

Select * from TuVung where TenChuDe not in ('Animal') and TenChuDe = 'Bugs and insects' and TenChuDe = 'Colors'

SELECT DISTINCT V.TenChuDe
FROM TuVung V INNER JOIN CauHoiTN Q
ON V.TenChuDe = Q.TenChuDe
WHERE V.MaTV = 'TV001'


SELECT MaCHTN,CauHoi,DapAnA,DapAnB,DapAnC,DapAnD,CauTraLoi,HinhAnh,TenChuDe FROM CauHoiTN WHERE MaTV='TV001' 
SELECT TOP 10 * FROM CauHoiTN where TenChuDe='Random' ORDER BY NEWID() 

/* Select một giá trị ngẫu nhiên từ bảng với MS SQL */   
SELECT TOP 10 * FROM CauHoiTN   ORDER BY NEWID() 

SELECT * FROM BaiKiemTra
UPDATE BaiKiemTra m , CapDo n 

UPDATE o
SET TenCapDo = 'Easy'
FROM CapDo o
INNER JOIN BaiKiemTra od
    ON o.TenCapDo = od.TenCapDo
WHERE MaBKT = 'BKT01';

UPDATE CapDo 
SET TenCapDo = 'Easy'
FROM CapDo o
JOIN BaiKiemTra u on o.TenCapDo = u.TenCapDo
WHERE u.MaBKT = 'BKT01'
AND o.Active != 0

UPDATE BaiKiemTra, CapDo
SET 
  BaiKiemTra.TenCapDo ='Dễ', 
  CapDo.TenCapDo ='Dễ',
FROM BaiKiemTra T1, CapDo T2
WHERE 
  T1.TenCapDo = T2.TenCapDo
AND 
  T1.TenCapDo = 'Easy'