<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Catálogo de Panes</title>
            </head>
            <body>
                <h1>Catálogo de Panes de la Panadería</h1>

                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Fermentación</th>
                            <th>Alveografía (W)</th>
                            <th>Hidratación (%)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:apply-templates select="PANES/PAN"/>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="PAN">
        <tr>
            <td><xsl:value-of select="normalize-space(ID)"/></td>
            <td><xsl:value-of select="normalize-space(NOMBRE)"/></td>
            <td><xsl:value-of select="normalize-space(FERMENTACION)"/></td>
            <td><xsl:value-of select="normalize-space(ALVEOGRAFIA)"/></td>
            <td><xsl:value-of select="normalize-space(HIDRATACION)"/></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>