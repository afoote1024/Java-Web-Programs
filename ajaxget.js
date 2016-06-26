  var req; 
  
  function getName(){ 
    var fname = document.getElementById("fname"); 
  
  
  var url = "/AJAX/AJAXGetServlet?fname=" + escape(fname.value); 
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
        var message = document.getElementById('message'); 
        message.value = req.responseText; 
      } 
    }
    clear();
  } 
  function clear(){ 
    var key = document.getElementById("fname"); 
    key.value=""; 
  }
  function focusIn(){ 
    document.getElementById("fname").focus();
  }