<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version = "1.0" 
xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
    <h1> User Details</h1>
    <table border="1">
        <tr bgcolor="yellow">
            <th style="text-align:left">Roll Number</th>
            <th style="text-align:left">Skill 1</th>            
            <th style="text-align:left">Proof 1</th>          
            <th style="text-align:left">Skill 2</th>          
            <th style="text-align:left">Proof 2</th>
            <th style="text-align:left">Skill 3</th>          
            <th style="text-align:left">Proof 3</th>
            <th style="text-align:left">Skill 4</th>
            <th style="text-align:left">Proof 4</th>
            <th style="text-align:left">Skill 5</th>
            <th style="text-align:left">Proof 5</th>
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
