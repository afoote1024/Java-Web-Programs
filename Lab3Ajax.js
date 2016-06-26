  var req; 
  
  function getMajor(){ 
    var StudentList = document.getElementById("StudentList"); 
    var url = "/Ajax/lab3Servlet?name=" + escape(StudentList.value); 
    if (window.XMLHttpRequest){ 
      req = new XMLHttpRequest(); 
    } 
    else if (window.ActiveXObject){ 
      req = new ActiveXObject("Microsoft.XMLHTTP"); 
    } 

    req.open("Get",url,true); 
    req.onreadystatechange = callback; 
    req.send(null);
  } 

  function callback(){ 
    if (req.readyState==4){ 
      if (req.status == 200){ 
        var message = document.getElementById('major'); 
        message.value = req.responseText; 
      } 
    }
    clear();
  } 
  function clear(){ 
    var key = document.getElementById("StudentList"); 
    key.value=""; 
  }
  function focusIn(){ 
    document.getElementById("StudentList").focus();
  }