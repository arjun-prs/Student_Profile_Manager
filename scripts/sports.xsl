<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version = "1.0" 
xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
    <h1> Sports</h1>
    <table border="1">
        <tr bgcolor="yellow">
            <th style="text-align:left">Roll number</th>
            <th style="text-align:left">Sport 1</th>            
            <th style="text-align:left">Sport 2</th>          
            <th style="text-align:left">Sport 3</th>          
            <th style="text-align:left">Sport 4</th>          
            <th style="text-align:left">Sport 5</th>
        </tr>
    <xsl:for-each select="root/row">
        <tr>
            <td><xsl:value-of select="roll_no"/></td>
            <td><xsl:value-of select="sport1"/></td>            
            <td><xsl:value-of select="sport2"/></td>            
            <td><xsl:value-of select="sport3"/></td>      
            <td><xsl:value-of select="sport4"/></td>        
            <td><xsl:value-of select="sport5"/></td>      
        </tr>
        </xsl:for-each>
        </table>
    </body>
    </html>
</xsl:template>
</xsl:stylesheet>
