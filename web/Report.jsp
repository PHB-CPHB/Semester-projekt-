<%-- 
Document : Report
Created on : Apr 7, 2016, 11:50:52 AM
Author : Thesoap
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
                    <tr><td style="height: 50px; border: 1px solid white"</td></tr>
                        <table style="width: 100%">
                            <td style="border: 1px solid white; border-right: 1px solid black; width: 60%"> Lokale______________</td>
                            <td style="border: 1px solid black"> Bemërkninger:<input type="checkbox" name="remark" value="yes"></td>
                            <td style="border: 1px solid black"> Ingen bemërkninger: <input type="checkbox" name="no-remark" value="no"> </td>
                            <tr>
                            <tr><td style="border: 1px solid white"></td></tr>
                        </table>
                        <table style="width: 100%">
                            <td style="width: 100%; font-size: x-large; border: 1px solid white;">
                            Skade og reparation
                        </td>
                    </table>
                    <table style="width: 100%">
                            </tr>
                            <th style="width: 10%"> Har der været skade i lokalet? </th>
                            <td><input type="checkbox" name="yesDamage" value="yesD"> Ja</td>
                            <td><input type="checkbox" name="noDamage" value="noD"> Nej</td>
                        </table>
                        <table style="width: 100%">
                            <th style="border-top: 1px solid white; width: 10%"> Hvornår </th>
                            <td style="border-top: 1px solid white"><input type="text" style="width: 100%; height: 20px"></td>
                            <th style="border-top: 1px solid white; width: 10%"> Hvor</th>
                            <td style="border-top: 1px solid white"><input type="text" style="width: 100%; height: 20px;"></td>

                        <tr>
                            <th style="border-top: 1px solid white"> Hvad er der sket </th>
                                <td style="border-top: 1px solid white"><input type="text" style="width: 100%; height: 20px"></td>
                                <th style="border-top: 1px solid white"> Hvad er repareret</th>
                                <td style="border-top: 1px solid white"><input type="text" style="width: 100%; height: 20px"></td>
                            </tr>
                        </table>
                        <table style="width: 100%">
                            <tr>
                                <th style="border-bottom: 1px solid lightgray; border-top: 1px solid white; width: 10%">Skade</th>
                                <td style="border-top: 1px solid white"><input type="checkbox" name="Fugt" value="YesFugt"> Fugt </td>

                            <tr></tr>
                            <th style="border-bottom: 1px solid lightgray"></th>
                            <td><input type="checkbox" name="RadOgSvamp" value="yesRadOgSvamp"> Räd og svamp </td>

                            <tr></tr>
                            <th style="border-bottom: 1px solid lightgray; border-top: 1px solid lightgray"></th>
                            <td><input type="checkbox" name="Skimmel" value="yesSkimmel"> Skimmel</td>

                            <tr></tr>
                            <th style="border-bottom:  1px solid lightgray; border-top: 1px solid lightgray"></th>
                            <td><input type="checkbox" name="Brand" value="yesBrand"> Brand</td>

                            <tr></tr>
                            <th style="border-top: 1px solid lightgray"></th>
                            <td><input type="checkbox" name="AndenSkade" value="yesAndenSkade"> Anden skade:<input type="text" style="border-bottom: 1px solid black"</td>

                            </td>
                            </tr>
                            <tr><td style="height: 50px; border: 1px solid white"</td></tr>
                        </table>


                        <table style="width: 100%">
                            <tr>
                                <td style="font-size: x-large; border: 1px solid white;"> Gennemgang af…</td>
                        </tr>
                        <td style="border: 1px solid white"></td>
                            <table style="width: 100%">
                                <td style="border: 1px solid white; border-right: 1px solid black; width: 40% "></td>
                                <td style="border-bottom: 1px solid white; width: 20%">Bemërkninger:</td>
                                <td style="border-bottom: 1px solid white; width: 20%">Ingen bemërkninger:</td>
                                <td style="border-bottom: 1px solid white; width: 20%"> Billede:</td>              
                            </table>
                            <table style="width: 100%">
                                <tr>
                                    <th style="width: 40%"> Vëgge</th>
                                    <td style="width: 20%"><input type="checkbox" name="remarkL" value="yesL"></td>
                                    <td style="width: 20%"><input type="checkbox" name="no-remarkL" value="noL"> </td>
                                    <td style="width: 20%"><input type="checkbox" name="pictureL" value="picL"></td>
                                </tr>
                            </table>
                            <table style="width: 100%">
                                <input type="text" style="width: 100%; height: 50px; border: 1px solid black; border-top: 1px solid white ">
                            </table>
                            <table style="width: 100%">
                                <tr>
                                    <th style="width: 40%">Loft </th>
                                    <td style="width: 20%"><input type="checkbox" name="remarkL" value="yesL"></td>
                                    <td style="width: 20%"><input type="checkbox" name="no-remarkL" value="noL"> </td>
                                    <td style="width: 20%"><input type="checkbox" name="pictureL" value="picL"></td>
                                </tr>
                            </table>
                            <table style="width: 100%">
                                <input type="text" style="width: 100%; height: 50px; border: 1px solid black; border-top: 1px solid white ">
                            </table></table>
                        <table style="width: 100%">
                            <tr>
                                <th style="width: 40%">Gulv </th>
                                <td style="width: 20%"><input type="checkbox" name="remarkG" value="yesG"></td>
                                <td style="width: 20%"><input type="checkbox" name="no-remarkG" value="noG"> </td>
                                <td style="width: 20%"><input type="checkbox" name="pictureG" value="picG"></td>
                            </tr>
                        </table>
                        <table style="width: 100%">
                            <input type="text" style="width: 100%; height: 50px; border: 1px solid black; border-top: 1px solid white ">
                        </table>
                        <table style="width: 100%">
                            <tr>
                                <th style="width: 40%">Vinduer/døre </th>
                                <td style="width: 20%"><input type="checkbox" name="remarkVD" value="yesVD"></td>
                                <td style="width: 20%"><input type="checkbox" name="no-remarkVD" value="noVD"> </td>
                                <td style="width: 20%"><input type="checkbox" name="pictureVD" value="picVD"></td>
                            </tr>
                        </table>
                        <table style="width: 100%">
                            <input type="text" style="width: 100%; height: 50px; border: 1px solid black; border-top: 1px solid white ">
                        </table>
                        <table style="width: 100%">
                            <tr>
                                <th style="width: 40%"></th>
                                <td style="width: 20%"><input type="checkbox" name="remark" value="yes"></td>
                                <td style="width: 20%"><input type="checkbox" name="no-remark" value="no"> </td>
                                <td style="width: 20%"><input type="checkbox" name="picture" value="pic"></td>
                            </tr>
                        </table>
                        <table style="width: 100%">
                            <input type="text" style="width: 100%; height: 50px; border: 1px solid black; border-top: 1px solid white ">
                        </table>
                        <table style="width: 100%">
                            <tr>
                                <th style="width: 40%"></th>
                                <td style="width: 20%"><input type="checkbox" name="remark" value="yes"></td>
                                <td style="width: 20%"><input type="checkbox" name="no-remark" value="no"> </td>
                                <td style="width: 20%"><input type="checkbox" name="picture" value="pic"></td>
                            </tr>
                        </table>
                        <table style="width: 100%">
                            <input type="text" style="width: 100%; height: 50px; border: 1px solid black; border-top: 1px solid white ">
                        </table>
                        <table style="width: 100%">
                            <tr><td style="height: 50px; border: 1px solid white"</td></tr>
                            <tr>
                                <td style="font-size: x-large; border: 1px solid white; border-bottom: 1px solid black"> Fugtscanning</td>
                            </tr>

                            <tr>
                                <th style="width: 30%">Er der foretaget fugtscanning?</th>
                                <td style="width: 20%"><input type="checkbox" name="yesFugtscanning" value="yesFugt">Ja</td>
                                <td style="width: 20%"><input type="checkbox" name="noFugtscanning" value="noFugt">Nej</td>
                            <tr></tr>
                            <th style="border: 1px solid black"> Fugtscanning </th>
                            <td><input type="text" style="width: 100%"></td>
                            <th> Målepunkt</th>
                            <td><input type="text" style="width: 100%"></td>
                            </tr>
                        </table>
                        <table style="width: 100%">
                            <input type="text" style="width: 100%; height: 50px; border: 1px solid black; border-top: 1px solid white ">
                            <tr><td style="height: 50px; border: 1px solid white"</td></tr>
                        </table>
                        <table style="width: 100%"
                               <tr>
                                <td style="font-size: x-large; border: 1px solid white; border-bottom: 1px solid black"> Konklussion</td>
                            </tr>
                            <th style="width: 20%">Lokale</th>
                            <th style="width: 80%">Anbefalinger</th>
                            <table style="width: 100%">
                                <td style="width: 20%"><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                <td style="width: 80%"><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                <tr>
                                    <td style="width: 20%"><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                    <td style="width: 80%"><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                </tr>
                                <td><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                <td><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                <tr>
                                    <td><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                    <td><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                    <td><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                    <td><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                    <td><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                    <td><input type="text" style="width: 100%; height: 50px; border: 1px solid black"></td>
                                </tr>
                            </table>
                        </table>
                        <table style="width: 100%">
                            <tr><td style="border: 1px solid white"></td></tr>
                            <tr><td style="border: 1px solid white; width: 800px">Bygningsgennemgangen er foretaget af <input type="text" style="width: 350px; border-bottom: 1px solid black">,Polygon</td></tr>
                            <tr><td style="border: 1px solid white"> I samarbejde med<input type="text" style="width: 493px; border-bottom: 1px solid black">,(bygningsansvarlig),</td></tr>

                            <tr><td style="height: 20px; border: 1px solid white"></td></tr>
                        </table>

                        <tr><td style="border: 1px solid white; height: 50px"></td></tr>
                        <table style="width: 100%">
                            <tr>
                                <td style="width: 1200px; text-align: left; ">
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
        <form action="AddBuildingController" method="POST">
            <input type="hidden" value="return" name="do_this">
            <input type="submit" value="Return" style="width: 30%; height: 30%; font-size: 100%;"/>

        </form>
    </body>
</html>
