<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version = "1.0" 
xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
    <h1> Semester wise GPA  Information of students</h1>
    <table border="1">
        <tr bgcolor="yellow">
            <th style="text-align:left">Roll number</th>
            <th style="text-align:left">SEM 1</th>            
            <th style="text-align:left">SEM 2</th>          
            <th style="text-align:left">SEM 3</th>          
            <th style="text-align:left">SEM 4</th>          
            <th style="text-align:left">SEM 5</th>
            <th style="text-align:left">SEM 6</th> 
            <th style="text-align:left">SEM 7</th>           
            <th style="text-align:left">SEM 8</th> 
        </tr>
    <xsl:for-each select="root/row">
        <tr>
            <td><xsl:value-of select="roll_no"/></td>
            <td><xsl:value-of select="sgpa1"/></td>            
            <td><xsl:value-of select="sgpa2"/></td>            
            <td><xsl:value-of select="sgpa3"/></td>      
            <td><xsl:value-of select="sgpa4"/></td>        
            <td><xsl:value-of select="sgpa5"/></td>
            <td><xsl:value-of select="sgpa6"/></td>
            <td><xsl:value-of select="sgpa7"/></td>
            <td><xsl:value-of select="sgpa8"/></td>           
        </tr>
        </xsl:for-each>
        </table>
    </body>
    </html>
</xsl:template>
</xsl:stylesheet>
