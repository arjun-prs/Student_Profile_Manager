<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version = "1.0" 
xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
    <h1> Social Media Profile links of students</h1>
    <table border="1">
        <tr bgcolor="blue">
            <th style="text-align:left">Roll number</th>
            <th style="text-align:left">LinkedIn</th>            
            <th style="text-align:left">Github</th>          
            <th style="text-align:left">Twitter</th>          
            <th style="text-align:left">Instagram</th>          
            <th style="text-align:left">Facebook</th>          
        </tr>
    <xsl:for-each select="root/row">
        <tr>
            <td><xsl:value-of select="roll_no"/></td>
            <td><xsl:value-of select="social1"/></td>            
            <td><xsl:value-of select="social2"/></td>            
            <td><xsl:value-of select="social3"/></td>      
            <td><xsl:value-of select="social4"/></td>        
            <td><xsl:value-of select="social5"/></td>           
        </tr>
        </xsl:for-each>
        </table>
    </body>
    </html>
</xsl:template>
</xsl:stylesheet>
