function show()
{
    var username = document.getElementById("userName").value;
    alert("用户名是："+username);
}

function change(ele)
{
    if (ele.style.color == "black")
    {
        ele.style.color = "red";
    }
    else
    {
        ele.style.color = "black";
    }
}