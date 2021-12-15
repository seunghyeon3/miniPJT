<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<script src="//cdn.ckeditor.com/4.17.1/standard/ckeditor.js"></script>
<script>
        document.addEventListener('DOMContentLoaded',function(){
        	 CKEDITOR.replace('product_content', {
        		 filebrowserUploadUrl: '../productServlet'
             } );
        })
    </script>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<jsp:include page="../nav.jsp"></jsp:include>
    <fieldset>
        <legend> 상품등록 </legend>
        <form action="../productServlet" name="product_Item" enctype="multipart/form-data" method="post">
            상품코드: <input type="text" name="product_id"><br>
            상품명 : <input type="text" name="product_name"><br>
            상품설명 : <textarea name="product_content"></textarea>
            <br> 평점 : <input type="text" name="product_eval"><br>
            상품가격 : <input type="number" name="product_price"><br>
            이미지 : <input type="file" name="product_picture"><br> <input type="submit" value="저장"><input type="reset" value="취소"> 	
        </form>
    </fieldset>
    
    <h3>상품리스트</h3>
    <div id="show">
        <table id="showTable">
        </table>
    </div>
    <script>
        let frm = document.forms.registerItem;
        let fields = ['product_id', 'product_name', 'product_content', 'product_eval', 'product_price', 'product_picture'];

        frm.addEventListener('submit', function (e) {
            e.preventDefault();

            let data = new FormData(frm);
            let xhtp = new XMLHttpRequest();
            xhtp.open('post', frm.getAttribute('action'));
            xhtp.send(data);
            
            xhtp.onload = function () {

                let data = JSON.parse(xhtp.responseText);
                let tbd = document.querySelector('#showTable>tbody');
                let tr = document.createElement('tr');
                for (let i = 0; i<fields.length; i++) {
                    let td = document.createElement('td');
                    console.log(data[fields[i]]);
                    if (fields[i] == 'image') {
                        let img = document.createElement('img');
                        img.setAttribute('src', '../upload/' + data[fields[i]]);
                        img.setAttribute('width', '100px');
                        img.setAttribute('alt', '사진이없습니다.');
                        td.appendChild(img);
                    } else {
                        td.textContent = data[fields[i]];
                    }
                    tr.appendChild(td);
                }
            
                tbd.appendChild(tr);
            };
        });

        //상품 리스트 출력
        let xhtp = new XMLHttpRequest();
        xhtp.open('get', '../productServlet');
        xhtp.send();
        xhtp.onload = function () {
            let data = JSON.parse(xhtp.responseText);
            console.log(data);

            let tbl = document.getElementById('showTable');
            tbl.setAttribute('border', '1');
            let thd = document.createElement('thead');
            let tbd = document.createElement('tbody');
            tbl.append(thd, tbd);
            
            let tr = document.createElement('tr');
            for (let i = 0; i < fields.length; i++) {    
                let th = document.createElement('th');
                th.textContent = fields[i];
                tr.appendChild(th);
            }
            thd.appendChild(tr);
         

            for (let i = 0; i < data.length; i++) {
                tr = document.createElement('tr');
                for (let field in fields) {
                    let td = document.createElement('td');
                    if (fields[field] == 'image' && data[i][fields[field]] != '0') {
                        let img = document.createElement('img');
                        img.setAttribute('src', '../upload/' + data[i][fields[field]]);
                        img.setAttribute('width', '100px');
                        img.setAttribute('alt', '사진이없습니다.');
                        td.appendChild(img);

                    } else {
                        td.textContent = data[i][fields[field]];
                    }
                    tr.append(td);
                }
               
                tbd.appendChild(tr);
            }
        }

        function delBtn(e){
        	console.log(e.target.parentNode.parentNode.children[0].textContent);
           e.target.parentNode.parentNode.remove();
        }

    </script>
</body>

</html>