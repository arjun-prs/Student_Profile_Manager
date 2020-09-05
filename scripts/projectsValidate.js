function onSubmit()
{
    var formElements = document.getElementsByTagName("input");
    var projRegEx = /[a-zA-Z_]+/;
    var urlRegEx = /https:\/\/github.com\/.*/
    var fillCount = 0;


    for(var i=0;i<formElements.length-1;i+=2)
    {
        if( !formElements[i].value  && formElements[i+1].value)
        {
            alert("Please fill respective project title for the link provided"); 
            formElements[i].focus();           
            return false;
        }

        if(formElements[i].value && formElements[i+1].value)
        {              

            if(projRegEx.test(formElements[i].value) == true)
            {
                if(urlRegEx.test(formElements[i+1].value) == true)
                {
                    fillCount+=1;
                }
                else{
                    alert("Please provide a valid github link.");
                    formElements[i+1].focus();
                    return false;
                }
            }else{
                alert("Please maintain spaces");
                return false;
            }
                

        }
    }

    if(!fillCount){
    alert("Please provide atleast one of your academic project.");
    return false;
    }
    else{
        alert("Projects updated !!!")
    }
    
    return true;
}

var tagCount = 2;
var addProjectandLink = `<br><div class="field is-grouped"><label class="label">${tagCount}. Project Title :&nbsp;&nbsp;</label><p class="control"><input class="input is-medium is-danger" id="p${tagCount}" type="text" placeholder="Enter project title" size="30px"></p><label class="label">Link :&nbsp;&nbsp;</label><p class="control "><input class="input is-medium is-success" id="l${tagCount}" type="text" placeholder="Link to repository" size="30px"></p></div>`;

function addProject()
{
    
    if(tagCount < 5)
    {
        // alert("function is calling")
        tagCount+=1;
        var addProjectandLink = `<br><div class="field is-grouped"><label class="label">${tagCount}. Project Title :&nbsp;&nbsp;</label><p class="control"><input class="input is-medium is-danger" id="p${tagCount}" type="text" placeholder="Enter project title" size="30px"></p><label class="label">Link :&nbsp;&nbsp;</label><p class="control "><input class="input is-medium is-success" id="l${tagCount}" type="text" placeholder="Link to repository" size="30px"></p></div>`;

        var form = document.getElementById("theinputs");
        console.log(form);
        form.innerHTML+=addProjectandLink;
    }
    if(tagCount == 5)
    {
        var addProjButton = document.getElementById("addProj");
        addProjButton.parentNode.removeChild(addProjButton); 
    }
}