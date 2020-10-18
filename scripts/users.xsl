<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version = "1.0" 
xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
    <h1> User Details</h1>
    <table border="1">
        <tr bgcolor="yellow">
            <th style="text-align:left">User ID</th>
            <th style="text-align:left">UserName</th>            
            <th style="text-align:left">Mobile Number</th>          
            <th style="text-align:left">E-Mail</th>          
            <th style="text-align:left">Resume</th>          
            <th style="text-align:left">Date of Birth</th>
            <th style="text-align:left">isAdmin</th>
            <th style="text-align:left">Gender</th>
            <th style="text-align:left">Password</th>
        </tr>
    <xsl:for-each select="root/row">
        <tr>
            <td><xsl:value-of select="user_id"/></td>
            <td><xsl:value-of select="user_name"/></td>            
            <td><xsl:value-of select="mob"/></td>            
            <td><xsl:value-of select="email"/></td>      
            <td><xsl:value-of select="resume_link"/></td>        
            <td><xsl:value-of select="dob"/></td>
            <td><xsl:value-of select="isAdmin"/></td>
            <td><xsl:value-of select="gender"/></td>
            <td><xsl:value-of select="pwd"/></td>      
        </tr>
        </xsl:for-each>
        </table>
    </body>
    </html>
</xsl:template>
</xsl:stylesheet>
