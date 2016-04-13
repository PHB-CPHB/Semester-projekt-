<%-- 
    Document   : Report
    Created on : Apr 7, 2016, 11:50:52 AM
    Author     : Thesoap
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
            <h1> Polygon</h1>
            <fieldset>
                <table>
                    <%-- first part: --%>
                    <td style="font-size: x-large; border: 1px solid white;">
                        General information om bygningen
                    </td>
                    <tr></tr>
                    <td style="border: 1px solid white;">
                        Byggeär:______________________________________________________________________________________
                    </td>
                    <tr>
                        <td style="border: 1px solid white">
                                Bygningsareal i m2 (hver etage tælles separat):________________________________________________________
                            </td>
                        </tr>
                        <td style="border: 1px solid white">
                            Hvad bruges bygningen til / Hvad har bygningen været brugt til?:_________________________________________
                        </td>
                        <tr></tr>


                        <%-- second part --%>
                        <tr><td style="height: 50px; border: 1px solid white"</td></tr>
                        <td style="font-size: x-large; border: 1px solid white; border-bottom: 1px solid black">
                            Gennemgang af bygningen udvendig
                        </td>
                        <tbody>
                            <tr>
                                <th> Tag</th>
                                <td>Bemërkninger:<input type="checkbox" name="remark" value="yes"></td>
                                <td>Ingen bemërkninger: <input type="checkbox" name="no-remark" value="no"> </td>
                                <td> Billede: <input type="checkbox" name="picture" value="pic"></td>
                            </tr>
                        <td style="height: 50px; border-right: 1px solid white"> <td style="border-left: 1px solid white; border-right: 1px solid white;"></td></td><td style="border-right: 1px solid white"><td></td>
                        </tbody>

                        <tbody>
                        <th>Ydervëgge</th>
                        <td>Bemërkninger:<input type="checkbox" name="remark" value="yes"></td>
                        <td>Ingen bemërkninger: <input type="checkbox" name="no-remark" value="no"> </td>
                        <td> Billede: <input type="checkbox" name="picture" value="pic"></td>
                        </tr>
                        <td style="height: 50px; border-right: 1px solid white"> <td style="border-left: 1px solid white; border-right: 1px solid white;"></td></td><td style="border-right: 1px solid white"><td></td>
                        </tbody>
                        <tr><td style="height: 50px; border: 1px solid white"</td></tr>

                        <tbody>
                        <td style="border: 1px solid white; border-right: 1px solid black"> Lokale______________</td>
                        <td> Bemërkninger:<input type="checkbox" name="remark" value="yes"></td>
                        <td> Ingen bemërkninger: <input type="checkbox" name="no-remark" value="no"> </td>
                        <tr>
                            <td style="font-size: x-large; border: 1px solid white; border-bottom: 1px solid black">
                                Skade og reparation
                            </td>
                        </tr>
                        <th style="border: 1px solid black"> Har der været skade i lokalet? </th>
                        <td><input type="checkbox" name="yesDamage" value="yesD"> Ja</td>
                        <td><input type="checkbox" name="noDamage" value="noD"> Nej</td>
                        <tr>
                            <th> Hvornår </th>
                            <td></td>
                            <th> Hvor</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th> Hvad er der sket </th>
                            <td></td>
                            <th> Hvad er repareret</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th style="border-bottom: 1px solid lightgray">Skade</th>
                            <td style="border-right: 1px solid white"><input type="checkbox" name="Fugt" value="YesFugt"> Fugt </td>
                            <td style="border-right: 1px solid white"></td><td></td>
                        <tr></tr>
                        <th style="border-bottom: 1px solid lightgray"></th>
                        <td style="border-right: 1px solid white"><input type="checkbox" name="RadOgSvamp" value="yesRadOgSvamp"> Räd og svamp </td>
                        <td style="border-right: 1px solid white"></td><td></td>
                        <tr></tr>
                        <th style="border-bottom: 1px solid lightgray; border-top: 1px solid lightgray"></th>
                        <td style="border-right: 1px solid white"><input type="checkbox" name="Skimmel" value="yesSkimmel"> Skimmel,</td>
                        <td style="border-right: 1px solid white"></td><td></td>
                        <tr></tr>
                        <th style="border-bottom:  1px solid lightgray; border-top: 1px solid lightgray"></th>
                        <td style="border-right: 1px solid white"><input type="checkbox" name="Brand" value="yesBrand"> Brand,</td>
                        <td style="border-right: 1px solid white"></td><td></td>
                        <tr></tr>
                        <th style="border-top: 1px solid lightgray"></th>
                        <td style="border-right: 1px solid white"><input type="checkbox" name="AndenSkade" value="yesAndenSkade"> Anden skade:</td>
                        <td style="border-right: 1px solid white">_______________</td><td></td>
                        </td>
                        </tr>
                        </tbody>

                        <tr><td style="height: 50px; border: 1px solid white"</td></tr>

                        <tr>
                            <td style="font-size: x-large; border: 1px solid white;"> Gennemgang af…</td>
                    </tr>
                    <td style="border-left: 1px solid white; border-right: 1px solid white"></td>
                        <tbody>
                            <tr>
                                <th> Vëgge</th>
                                <td>Bemërkninger:<input type="checkbox" name="remarkV" value="yesV"></td>
                                <td>Ingen bemërkninger: <input type="checkbox" name="no-remarkV" value="noV"> </td>
                                <td> Billede: <input type="checkbox" name="pictureV" value="picV"></td>
                            </tr>
                        <td style="height: 50px; border-right: 1px solid white"> <td style="border-left: 1px solid white; border-right: 1px solid white;"></td></td><td style="border-right: 1px solid white"><td></td>
                        </tbody>
                        <tbody>
                            <tr>
                                <th>Loft </th>
                                <td><input type="checkbox" name="remarkL" value="yesL"></td>
                                <td><input type="checkbox" name="no-remarkL" value="noL"> </td>
                                <td><input type="checkbox" name="pictureL" value="picL"></td>
                            </tr>
                        <td style="height: 50px; border-right: 1px solid white"> <td style="border-left: 1px solid white; border-right: 1px solid white;"></td></td><td style="border-right: 1px solid white"><td></td>
                        </tbody>
                        <tbody>
                            <tr>
                                <th>Gulv </th>
                                <td><input type="checkbox" name="remarkG" value="yesG"></td>
                                <td><input type="checkbox" name="no-remarkG" value="noG"> </td>
                                <td><input type="checkbox" name="pictureG" value="picG"></td>
                            </tr>
                        <td style="height: 50px; border-right: 1px solid white"> <td style="border-left: 1px solid white; border-right: 1px solid white;"></td></td><td style="border-right: 1px solid white"><td></td>
                        </tbody>
                        <tbody>
                            <tr>
                                <th>Vinduer/døre </th>
                                <td><input type="checkbox" name="remarkVD" value="yesVD"></td>
                                <td><input type="checkbox" name="no-remarkVD" value="noVD"> </td>
                                <td><input type="checkbox" name="pictureVD" value="picVD"></td>
                            </tr>
                        <td style="height: 50px; border-right: 1px solid white"> <td style="border-left: 1px solid white; border-right: 1px solid white;"></td></td><td style="border-right: 1px solid white"><td></td>
                        </tbody>
                        <tbody>
                            <tr>
                                <th></th>
                                <td><input type="checkbox" name="remark" value="yes"></td>
                                <td><input type="checkbox" name="no-remark" value="no"> </td>
                                <td><input type="checkbox" name="picture" value="pic"></td>
                            </tr>
                        <td style="height: 50px; border-right: 1px solid white"> <td style="border-left: 1px solid white; border-right: 1px solid white;"></td></td><td style="border-right: 1px solid white"><td></td>
                        </tbody>
                        <tbody>
                            <tr>
                                <th></th>
                                <td><input type="checkbox" name="remark" value="yes"></td>
                                <td><input type="checkbox" name="no-remark" value="no"> </td>
                                <td><input type="checkbox" name="picture" value="pic"></td>
                            </tr>
                        <td style="height: 50px; border-right: 1px solid white"> <td style="border-left: 1px solid white; border-right: 1px solid white;"></td></td><td style="border-right: 1px solid white"><td></td>
                        </tbody>

                        <tr><td style="height: 50px; border: 1px solid white"</td></tr>
                        <tr>
                            <td style="font-size: x-large; border: 1px solid white; border-bottom: 1px solid black"> Fugtscanning</td>
                        </tr>
                        <tr>
                            <th>Er der foretaget fugtscanning?</th>
                            <td><input type="checkbox" name="yesFugtscanning" value="yesFugt">Ja</td>
                            <td><input type="checkbox" name="noFugtscanning" value="noFugt">Nej</td>
                        <tr></tr>
                        <th style="border: 1px solid black"> Fugtscanning </th>
                        <td></td>
                        <th> Målepunkt</th>
                        <td></td>
                        </tr>
                        <td style="height: 50px; border-right: 1px solid white"> <td style="border-left: 1px solid white; border-right: 1px solid white;"></td></td><td style="border-right: 1px solid white"><td></td>

                        <tr><td style="height: 50px; border: 1px solid white"</td></tr>
                        <tr>
                            <td style="font-size: x-large; border: 1px solid white; border-bottom: 1px solid black"> Konklussion</td>
                        </tr>

                        <th>Lokale</th>
                        <th>Anbefalinger</th>
                        <tr><td style="height: 20px; border-right: 1px solid black"> <td style="border-left: 1px solid black; border-right: 1px solid black;"></td></tr>
                    <tr><td style="height: 20px; border-right: 1px solid black"> <td style="border-left: 1px solid black; border-right: 1px solid black;"></td></tr>
                    <tr><td style="height: 20px; border-right: 1px solid black"> <td style="border-left: 1px solid black; border-right: 1px solid black;"></td></tr>
                    <tr><td style="height: 20px; border-right: 1px solid black"> <td style="border-left: 1px solid black; border-right: 1px solid black;"></td></tr>
                    <tr><td style="height: 20px; border-right: 1px solid black"> <td style="border-left: 1px solid black; border-right: 1px solid black;"></td></tr>
                    <tr><td style="height: 20px; border-right: 1px solid black"> <td style="border-left: 1px solid black; border-right: 1px solid black;"></td></tr>

                    <tr><td style="border: 1px solid white"></td></tr>
                        <tr><td style="border: 1px solid white; width: 800px">Bygningsgennemgangen er foretaget af _________________________________________,Polygon</td></tr>
                        <tr><td style="border: 1px solid white"> I samarbejde med___________________________________________________________,(bygningsansvarlig),</td></tr>

                        <tr><td style="height: 20px; border: 1px solid white"></td></tr>
                        <td style="font-size: x-large; border: 1px solid white;">
                        Bygningen er kategoriseret som
                    </td>
                    <tr></tr>
                    <table style="width: 1200px">
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
                        <table>
                            <tr>
                                <td style="width: 1200px; border: 1px solid white; text-align: left; ">
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
                </table>
            </fieldset>
        </center>
        <input type="submit" value="Return"/>
    </body>
</html>
