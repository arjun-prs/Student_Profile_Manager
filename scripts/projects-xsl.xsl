<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version = "1.0" 
xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
    <h1> Project Information of students</h1>
    <table border="1">
        <tr bgcolor="red">
            <th style="text-align:left">Roll number</th>
            <th style="text-align:left">Project 1</th>
            <th style="text-align:left">Proof 1</th>
            <th style="text-align:left">Project 2</th>
            <th style="text-align:left">Proof 2</th>
            <th style="text-align:left">Project 3</th>
            <th style="text-align:left">Proof 3</th>
            <th style="text-align:left">Project 4</th>
            <th style="text-align:left">Proof 4</th>
            <th style="text-align:left">Project 5</th>
            <th style="text-align:left">Proof 5</th>
        </tr>
    <xsl:for-each select="root/row">
        <tr>
            <td><xsl:value-of select="roll_no"/></td>
            <td><xsl:value-of select="project1"/></td>
            <td><xsl:value-of select="proof1"/></td>
            <td><xsl:value-of select="project2"/></td>
            <td><xsl:value-of select="proof2"/></td>
            <td><xsl:value-of select="project3"/></td>
            <td><xsl:value-of select="proof3"/></td>
            <td><xsl:value-of select="project4"/></td>
            <td><xsl:value-of select="proof4"/></td>
            <td><xsl:value-of select="project5"/></td>
            <td><xsl:value-of select="proof5"/></td>
        </tr>
        </xsl:for-each>
        </table>
    </body>
    </html>
</xsl:template>
</xsl:stylesheet>
