
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>测试您的BMI指数</title>
    <script type="text/javascript">
      function search() {
        //1.创建异步请求对象
        var xmlHttpRequest = new XMLHttpRequest();
        //2.绑定“异步请求对象状态变化”事件
        xmlHttpRequest.onreadystatechange=function () {
          if (xmlHttpRequest.status==200 && xmlHttpRequest.readyState==4){
            var bmi = xmlHttpRequest.responseText;
            document.getElementById("div1").innerText=bmi;
          }
        }
        //3.初始化请求
        var height = document.getElementById("height").value;
        var weight = document.getElementById("weight").value;
        url = "bmi?height="+height+"&weight="+weight;
        xmlHttpRequest.open("get",url,true);
        //4.发送请求
        xmlHttpRequest.send();
      }
    </script>
  </head>
  <body>
  <form >
    <table>
      <tr>
        <td>身高(M)</td>
        <td><input type="text" name="height" id="height"></td>
      </tr>
      <tr>
        <td>体重(KG)</td>
        <td><input type="text" name="weight" id="weight"></td>
      </tr>
      <tr>
        <td><input type="button" value="提交" id="submit" onclick="search()" ></td>
        <td><input type="reset" ></td>
      </tr>
    </table>
  </form><br>
  <div id="div1" align="center"></div>

  </body>
</html>
