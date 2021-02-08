<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<ul>
				<li><a href="/RDVMed/Accueil.jsp">Accueil</a></li>
				<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
				<c:if test="${utilisateur.userRole eq 'Medecin'}">
					<li><a href="/RDVMed/Medecin/GestionCompte.jsp">Gestion de compte medecin</a></li>
					<li><a href="/RDVMed/Medecin/Agenda">Créer ses agendas</a></li>
				</c:if>
				Bonjour ${prenom} ${nom}
				<li><a href="/RDVMed/ServletLogout">Se déconnecter</a></li>
			</ul>
			
			   <div id="scheduler"></div>
			   
			       <link rel="stylesheet" href="../jqwidgets/styles/jqx.base.css" type="text/css" />
    <script type="text/javascript" src="../scripts/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="../scripts/demos.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxdata.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxdate.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxscheduler.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxscheduler.api.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxdatetimeinput.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxmenu.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxcalendar.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxtooltip.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxwindow.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxcheckbox.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxlistbox.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxdropdownlist.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxnumberinput.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxradiobutton.js"></script>
    <script type="text/javascript" src="../jqwidgets/jqxinput.js"></script>
    <script type="text/javascript" src="../jqwidgets/globalization/globalize.js"></script>
    <script type="text/javascript" src="../jqwidgets/globalization/globalize.culture.de-DE.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var appointments = new Array();

            var source =
            {
                dataType: "array",
                dataFields: [
                    { name: 'id', type: 'string' },
                    { name: 'description', type: 'string' },
                    { name: 'location', type: 'string' },
                    { name: 'subject', type: 'string' },
                    { name: 'calendar', type: 'string' },
                    { name: 'start', type: 'date' },
                    { name: 'end', type: 'date' }
                ],
                id: 'id',
                localData: appointments
            };
            var adapter = new $.jqx.dataAdapter(source);
            $("#scheduler").jqxScheduler({
                date:  new $.jqx.date('todayDate'),
                max:  new $.jqx.date(2021,02,28),
                min:  new $.jqx.date('todayDate'),
                localization: {
                    // separator of parts of a date (e.g. '/' in 11/05/1955)
                    '/': "/",
                    // separator of parts of a time (e.g. ':' in 05:44 PM)
                    ':': ":",
                    // the first day of the week (0 = Sunday, 1 = Monday, etc)
                    firstDay: 1,
                    days: {
                        // full day names
                        names: ["Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"],
                        // abbreviated day names
                        namesAbbr: ["Sonn", "Mon", "Dien", "Mitt", "Donn", "Fre", "Sams"],
                        // shortest day names
                        namesShort: ["So", "Mo", "Di", "Mi", "Do", "Fr", "Sa"]
                    },
                    months: {
                        // full month names (13 months for lunar calendards -- 13th month should be "" if not lunar)
                        names: ["Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember", ""],
                        // abbreviated month names
                        namesAbbr: ["Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dez", ""]
                    },
                    // AM and PM designators in one of these forms:
                    // The usual view, and the upper and lower case versions
                    //      [standard,lowercase,uppercase]
                    // The culture does not use AM or PM (likely all standard date formats use 24 hour time)
                    //      null
                    AM: ["AM", "am", "AM"],
                    PM: ["PM", "pm", "PM"],
                    eras: [
                    // eras in reverse chronological order.
                    // name: the name of the era in this culture (e.g. A.D., C.E.)
                    // start: when the era starts in ticks (gregorian, gmt), null if it is the earliest supported era.
                    // offset: offset in years from gregorian calendar
                    { "name": "A.D.", "start": null, "offset": 0 }
                    ],
                    twoDigitYearMax: 2029,
                    patterns: {
                        // short date pattern
                        d: "M/d/yyyy",
                        // long date pattern
                        D: "dddd, MMMM dd, yyyy",
                        // short time pattern
                        t: "h:mm tt",
                        // long time pattern
                        T: "h:mm:ss tt",
                        // long date, short time pattern
                        f: "dddd, MMMM dd, yyyy h:mm tt",
                        // long date, long time pattern
                        F: "dddd, MMMM dd, yyyy h:mm:ss tt",
                        // month/day pattern
                        M: "MMMM dd",
                        // month/year pattern
                        Y: "yyyy MMMM",
                        // S is a sortable format that does not vary by culture
                        S: "yyyy\u0027-\u0027MM\u0027-\u0027dd\u0027T\u0027HH\u0027:\u0027mm\u0027:\u0027ss",
                        // formatting of dates in MySQL DataBases
                        ISO: "yyyy-MM-dd hh:mm:ss",
                        ISO2: "yyyy-MM-dd HH:mm:ss",
                        d1: "dd.MM.yyyy",
                        d2: "dd-MM-yyyy",
                        d3: "dd-MMMM-yyyy",
                        d4: "dd-MM-yy",
                        d5: "H:mm",
                        d6: "HH:mm",
                        d7: "HH:mm tt",
                        d8: "dd/MMMM/yyyy",
                        d9: "MMMM-dd",
                        d10: "MM-dd",
                        d11: "MM-dd-yyyy"
                    },
                    backString: "Vorhergehende",
                    forwardString: "Nächster",
                    toolBarPreviousButtonString: "Vorhergehende",
                    toolBarNextButtonString: "Nächster",
                    emptyDataString: "Nokeine Daten angezeigt",
                    loadString: "Loading...",
                    clearString: "Löschen",
                    todayString: "Heute",
                    dayViewString: "Tag",
                    weekViewString: "Woche",
                    monthViewString: "Monat",
                    timelineDayViewString: "Zeitleiste Day",
                    timelineWeekViewString: "Zeitleiste Woche",
                    timelineMonthViewString: "Zeitleiste Monat",
                    loadingErrorMessage: "Die Daten werden noch geladen und Sie können eine Eigenschaft nicht festgelegt oder eine Methode aufrufen . Sie können tun, dass, sobald die Datenbindung abgeschlossen ist. jqxScheduler wirft die ' bindingComplete ' Ereignis, wenn die Bindung abgeschlossen ist.",
                    editRecurringAppointmentDialogTitleString: "Bearbeiten Sie wiederkehrenden Termin",
                    editRecurringAppointmentDialogContentString: "Wollen Sie nur dieses eine Vorkommen oder die Serie zu bearbeiten ?",
                    editRecurringAppointmentDialogOccurrenceString: "Vorkommen bearbeiten",
                    editRecurringAppointmentDialogSeriesString: "Bearbeiten Die Serie",
                    editDialogTitleString: "Termin bearbeiten",
                    editDialogCreateTitleString: "Erstellen Sie Neuer Termin",
                    contextMenuEditAppointmentString: "Termin bearbeiten",
                    contextMenuCreateAppointmentString: "Erstellen Sie Neuer Termin",
                    editDialogSubjectString: "Subjekt",
                    editDialogLocationString: "Ort",
                    editDialogFromString: "Von",
                    editDialogToString: "Bis",
                    editDialogAllDayString: "Den ganzen Tag",
                    editDialogExceptionsString: "Ausnahmen",
                    editDialogResetExceptionsString: "Zurücksetzen auf Speichern",
                    editDialogDescriptionString: "Bezeichnung",
                    editDialogResourceIdString: "Kalender",
                    editDialogStatusString: "Status",
                    editDialogColorString: "Farbe",
                    editDialogColorPlaceHolderString: "Farbe wählen",
                    editDialogTimeZoneString: "Zeitzone",
                    editDialogSelectTimeZoneString: "Wählen Sie Zeitzone",
                    editDialogSaveString: "Sparen",
                    editDialogDeleteString: "Löschen",
                    editDialogCancelString: "Abbrechen",
                    editDialogRepeatString: "Wiederholen",
                    editDialogRepeatEveryString: "Wiederholen alle",
                    editDialogRepeatEveryWeekString: "woche(n)",
                    editDialogRepeatEveryYearString: "Jahr (en)",
                    editDialogRepeatEveryDayString: "Tag (e)",
                    editDialogRepeatNeverString: "Nie",
                    editDialogRepeatDailyString: "Täglich",
                    editDialogRepeatWeeklyString: "Wöchentlich",
                    editDialogRepeatMonthlyString: "Monatlich",
                    editDialogRepeatYearlyString: "Jährlich",
                    editDialogRepeatEveryMonthString: "Monate (n)",
                    editDialogRepeatEveryMonthDayString: "Day",
                    editDialogRepeatFirstString: "erste",
                    editDialogRepeatSecondString: "zweite",
                    editDialogRepeatThirdString: "dritte",
                    editDialogRepeatFourthString: "vierte",
                    editDialogRepeatLastString: "letzte",
                    editDialogRepeatEndString: "Ende",
                    editDialogRepeatAfterString: "Nach",
                    editDialogRepeatOnString: "Am",
                    editDialogRepeatOfString: "von",
                    editDialogRepeatOccurrencesString: "Eintritt (e)",
                    editDialogRepeatSaveString: "Vorkommen Speichern",
                    editDialogRepeatSaveSeriesString: "Save Series",
                    editDialogRepeatDeleteString: "Vorkommen löschen",
                    editDialogRepeatDeleteSeriesString: "Series löschen",
                    editDialogStatuses:
                    {
                        free: "Frei",
                        tentative: "Versuchsweise",
                        busy: "Beschäftigt",
                        outOfOffice: "Ausserhaus"
                    }
                },
                statuses:

                {
                	free: "green",
                	busy: "red",
                 },
                	
                width: 700,
                height: 500,
                source: adapter,
                view: 'weekView',
                showLegend: true,
                ready: function () {
                    $("#scheduler").jqxScheduler('ensureAppointmentVisible', 'id1');
                },
                resources:
                {
                    colorScheme: "scheme05",
                    dataField: "calendar",
                    source: new $.jqx.dataAdapter(source)
                },
                appointmentDataFields:
                {
                    from: "start",
                    to: "end",
                    id: "id",
                    description: "description",
                    subject: "subject",
                    resourceId: "calendar"
                },
                views:
                [
                    'weekView'
                ]
            });
        });
    </script>
</body>
</html>