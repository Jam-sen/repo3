<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省份查询</title>
    <script type="text/javascript">
        function query() {
            //1.创建异步请求对象
            var xmlRequest = new XMLHttpRequest();
            //2.给异步对象绑定“状态变化”事件
            xmlRequest.onreadystatechange = function () {
                //5.符合条件后接收服务器响应的数据
                //状态码为200 说明响应的是完整的资源文件 ；异步对象状态为4 说明异步对象发送请求完成）
                if (xmlRequest.status == 200 && xmlRequest.readyState == 4) {
                    //异步响应对象的responseText属性就是服务器相应的数据
                    var responseText = xmlRequest.responseText;
                    //使用js的eval方法将字符串转换为json对象
                    var json = eval("(" + responseText + ")");
                    //更新页面（使用json对象中的数据更新dom对象的属性）
                    document.getElementById("provinceName").value = json.name;
                    document.getElementById("jianCheng").value = json.jiancheng;
                    document.getElementById("shengHui").value = json.shenghui;
                }
            }
            //3.初始化请求
            var provinceId = document.getElementById("provinceId").value;
            var url = "queryprovincebyid?provinceId=" + provinceId;
            xmlRequest.open("get", url, true)
            //4.发送请求
            xmlRequest.send();
        }

        function FuzzySearch() {
            var xmlRequest = new XMLHttpRequest();
            xmlRequest.onreadystatechange = function () {
                if (xmlRequest.readyState == 4 && xmlRequest.status == 200) {
                    var fuzzyName = xmlRequest.responseText;
                    document.getElementById("div1").innerText = fuzzyName;
                }
            }
            var provinceName = document.getElementById("provinceName").value;
            var url = "fuzzysearch?provinceName=" + provinceName;
            xmlRequest.open("get", url, true);
            xmlRequest.send();
        }

        function cityCount() {
            var xmlRequest = new XMLHttpRequest();
            xmlRequest.onreadystatechange = function () {
                if (xmlRequest.readyState === 4 && xmlRequest.status === 200) {
                    var cityCount = xmlRequest.responseText;
                    alert(cityCount);
                }
            }
            var provinceName = document.getElementById("provinceName").value;
            var url = "citycount?provinceName=" + provinceName;
            xmlRequest.open("get", url, true);
            xmlRequest.send();
        }
    </script>
</head>
<body>
<font size="4" color="red">查询省份信息</font>
<table align="center">
    <tr>
        <td>省份编号</td>
        <td>
            <input type="text" name="provinceId" id="provinceId">
            <input type="button" id="query" value="查询" onclick="query()">
        </td>
    </tr>
    <tr>
        <td>省份名称</td>
        <td>
            <input type="text" id="provinceName" onchange="FuzzySearch()">
            <input type="button" value="查询城市数量" onclick="cityCount()">
        </td>
    </tr>
    <tr>
        <td>省份简称</td>
        <td><input type="text" id="jianCheng"></td>
    </tr>
    <tr>
        <td>省会城市</td>
        <td><input type="text" id="shengHui"></td>
    </tr>
</table>
<br>
<div align="center" id="div1"></div>
</body>
</html>
