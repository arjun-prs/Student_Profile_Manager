function onSubmitSocial()
{
    var formElements = document.getElementsByTagName("input");
    var fbRegEx = /https:\/\/www.facebook.com\/.*/
    var linkedinRegEx = /https:\/\/www.linkedin.com\/.*/
    var twitterRegEx = /https:\/\/twitter.com\/.*/
    var githubRegEx = /https:\/\/github.com\/.*/
    var igRegEx = /https:\/\/www.instagram.com\/.*/
    var linkCount = 0;
    
    if(formElements[0].value != "")
    {
        linkCount+=1;
        if(fbRegEx.test(formElements[0].value) == false)
        {
            alert("Provide correct URL for facebook");
            return false;
        }
    }

    if(formElements[1].value != "")
    {
        linkCount+=1;
        if(linkedinRegEx.test(formElements[1].value) == false)
        {
            alert("Provide correct URL for LinkedIn");
            return false;
        }
    }

    if(formElements[2].value != "")
    {
        linkCount+=1;
        if(twitterRegEx.test(formElements[2].value) == false)
        {
            alert("Provide correct URL for twitter");
            return false;
        }
    }

    if(formElements[3].value != "")
    {
        linkCount+=1;
        if(githubRegEx.test(formElements[3].value) == false)
        {
            alert("Provide correct URL for github");
            return false;

        }
    }

    if(formElements[4].value != "")
    {
        linkCount+=1;
        if(igRegEx.test(formElements[4].value) == false)
        {
            alert("Provide correct URL for Instagram");
            return false;

        }
    }

    if(!linkCount)
    {
        alert("Please provide atleast one social media link of yours.");
    }else{
        alert("Information updated successfully.");
    }




}