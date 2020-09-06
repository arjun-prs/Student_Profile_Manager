function login(){    
    var elements = document.getElementsByTagName("input");

    if((elements[0].value == "") && (elements[1].value == ""))
    {
      alert("Please enter userid and password to proceed");
    return false;
    }
    if((elements[0].value == ""))
    {
      alert("Please enter username");
    return false;
    }

    if((elements[1].value == ""))
    {
      alert("Please enter password");
    return false;
    }

    if(elements[0].value == "admin" || elements[0].value == "ADMIN")
    {
      alert("Hello Admin.");
      
    } 
    else{
    alert(`Hi ${elements[0].value}` );
    }
}