<%-- 
    Document   : BReport
    Created on : 18-04-2016, 10:33:43
    Author     : ejer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <style>
            body {background-color: white;}
            h1 {color: darkblue; font-size: xx-large}
            th {background-color: lightgray;}

            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
                text-align: left;
            }
            th, td {
                padding: 5px;

            </style>
        <center>
            <h1>Polygon</h1>
            <table style="width:  100%">
                    <td style="font-size: x-large; border: 1px solid white;">
                    General information om bygningen
                </td>
                <tr></tr>
                <td style="border: 1px solid white;">
                    Byggeår:<input style="border-bottom: 1px solid black; width: 54%" type="text"> 
                </td>
                <tr>
                    <td style="border: 1px solid white">
                            Bygningsareal i m2 (hver etage tælles separat):<input style="border-bottom: 1px solid black; width: 38%" type="text"> 
                        </td>
                    </tr>
                    <td style="border: 1px solid white">
                        Hvad bruges bygningen til / Hvad har bygningen været brugt til?:<input style="border-bottom: 1px solid black; width: 30%" type="text"> 
                    </td>
                    <tr></tr>
                </table>


                <%-- second part --%>
                <tr><td style="height: 50px; border: 1px solid white"</td></tr>
                <table style="width: 100%">
                    <td style="font-size: x-large; border: 1px solid white; border-bottom: 1px solid black">
                        Gennemgang af bygningen udvendig
                    </td>
                    <tr>
                        <th style="border: 1px solid black; width: 40%"> Tag</th>
                        <td>Bemærkninger:<input type="checkbox" name="remark" value="yes"></td>
                        <td>Ingen bemærkninger: <input type="checkbox" name="no-remark" value="no"> </td>
                        <td> Billede: <input type="checkbox" name="picture" value="pic"></td>
                    </tr>
                </table>
                <table style="width: 100%">
                    <input type="text" style="width: 100%; height: 50px; border: 1px solid black; border-top: 1px solid white">
                </table>
                <table style="width: 100%">
                    <th style="width: 40%">Ydervægge</th>
                    <td>Bemærkninger:<input type="checkbox" name="remark" value="yes"></td>
                    <td>Ingen bemærkninger: <input type="checkbox" name="no-remark" value="no"> </td>
                    <td> Billede: <input type="checkbox" name="picture" value="pic"></td>
                    </tr>
                </table>
                <table style="width: 100%">
                    <input type="text" style="width: 100%; height: 50px; border: 1px solid black; border-top: 1px solid white">
                </table>
                <table style="width: 100%">
                    <tr><td style="border: 1px solid white"></td></tr>
                    <tr><td style="border: 1px solid white; width: 800px">Bygningsgennemgangen er foretaget af <input type="text" style="width: 350px; border-bottom: 1px solid black">,Polygon</td></tr>
                    <tr><td style="border: 1px solid white"> I samarbejde med<input type="text" style="width: 493px; border-bottom: 1px solid black">,(bygningsansvarlig),</td></tr>

                    <tr><td style="height: 20px; border: 1px solid white"></td></tr>
                    <td style="font-size: x-large; border: 1px solid white;">
                    Bygningen er kategoriseret som
                </td>
            </table>

            <tr></tr>
            <table style="width: 100%">
                    <th style="width: 100px">Tilstand</th>
                    <th style="width: 275px">Beskrivelse af bygningen</th>
                    <th style="width: 275px">Funktion af bygningen</th>
                    <th style="width: 100px">Tilstandsgrad</th>
                    <tr></tr>
                    <th>Tilstandsgrad 0</th>
                    <th>Bygningsdelen er ny og som bygget</th>
                    <th>Funktionen er som beskrevet</th>
                    <td><input type="checkbox" name="tilstand0" value="nul" </td>
                    <tr></tr>
                    <th>Tilstandsgrad 1</th>
                    <th>Bygningsdelen er intakt, men med begyndende slid og synlige skader (kun kosmetiske skader)
                    </th>
                    <th>Funktionen er som beskrevet
                    </th>
                    <td><input type="checkbox" name="tilstand1" value="en" </td>
                    <tr></tr>
                    <th>Tilstandsgrad 2</th>
                    <th>Bygningsdelen er begyndt at forfalde, med enkelte defekte komponenter</th>
                    <th>Funktionen er nedsat – fare for følgeskader</th>
                    <td><input type="checkbox" name="tilstand2" value="to" </td>
                    <tr></tr>
                    <th>Tilstandsgrad 3</th>
                    <th>Bygningsdelen er nedbrudt og skal udskiftes</th>
                    <th>Funktionen er nedsat – fare for følgeskader</th>
                    <td><input type="checkbox" name="tilstand3" value="tre" </td>
                </table>
                <table style="width: 100%">
                    <tr>
                        <td style="width: 1200px; border-top: 1px solid white; text-align: left; ">
                        Denne rapport og bygningsgennemgang er lavet for at klarlægge umiddelbare visuelle problemstillinger. Vores formål er at sikre, at
                        bygningens anvendelse kan opretholdes. Vi udbedrer ikke skader som en del af bygningsgennemgangen/rapporten. Gennemgangen
                        af bygningen indeholder ikke fugtmålinger af hele bygningen, men vi kan foretage fugtscanninger enkelte steder i bygningen, hvis vi
                        finder det nødvendigt. Hvis vi finder kritiske områder i bygningen vil vi fremlægge anbefalinger angående yderligere tiltag så som
                        yderligere undersøgelser, reparationer eller bygningsopdateringer.
                        Bemærk at vi skal have adgang til hele bygningen for at kunne udføre en fuld gennemgang (dette inkluderer adgang til tag, tagrum,
                        kælder, krybekælder eller andre aflukkede områder). Denne bygningsgennemgang er ikke-destruktiv. Hvis der skal laves destruktive
                        indgreb, skal dette først godkendes af de bygningsansvarlige. Destruktive indgreb er ikke en del af denne rapport eller
                        bygningsgennemgang.
                        Den bygningsansvarlige skal udlevere plantegning over bygningen inden bygningsgennemgangen kan foretages. 
                    </td>
                </tr>
            </table>
        </center>
        <form action="AddBuildingController" method="POST">
            <input type="hidden" value="return" name="do_this">
            <input type="submit" value="Return" style="width: 30%; height: 30%; font-size: 100%;"/>
        </form>
    </body>
</html>
