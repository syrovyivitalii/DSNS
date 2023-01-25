package LDUBGD.DSNS.repository;
/**
 *
 * https://map.ukrainealarm.com/api/data/getHistory
 * https://api.ukrainealarm.com/api/v3/alerts/1602
 * [
 *     {
 *         "regionId": "1602",
 *         "regionType": "Community",
 *         "regionName": "Яблунівська територіальна громада",
 *         "lastUpdate": "2022-12-05T14:11:09Z",
 *         "activeAlerts": []
 *     }
 * ]
 * {
 *         "totalDurations": [
 *         {
 *         "regionId": "28",
 *         "regionName": "Донецька область",
 *         "durationVal": "40 д. 9 год. 30 хв.",
 *         "percentage": 16.10588699087088,
 *         "alertsCount": 1215,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "9",
 *         "regionName": "Дніпропетровська область",
 *         "durationVal": "33 д. 8 год. 42 хв.",
 *         "percentage": 13.301712212793806,
 *         "alertsCount": 1057,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "12",
 *         "regionName": "Запорізька область",
 *         "durationVal": "37 д. 16 год. 35 хв.",
 *         "percentage": 15.027363321138646,
 *         "alertsCount": 1134,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "17",
 *         "regionName": "Миколаївська область",
 *         "durationVal": "37 д. 9 год. 52 хв.",
 *         "percentage": 14.915728088991223,
 *         "alertsCount": 817,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "18",
 *         "regionName": "Одеська область",
 *         "durationVal": "19 д. 13 год. 53 хв.",
 *         "percentage": 7.805959438231984,
 *         "alertsCount": 527,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "15",
 *         "regionName": "Кіровоградська область",
 *         "durationVal": "25 д. 12 год. 9 хв.",
 *         "percentage": 10.169320556696432,
 *         "alertsCount": 698,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "31",
 *         "regionName": "м. Київ",
 *         "durationVal": "21 д. 3 год. 51 хв.",
 *         "percentage": 8.43675487719562,
 *         "alertsCount": 485,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "10",
 *         "regionName": "Житомирська область",
 *         "durationVal": "19 д. 14 хв.",
 *         "percentage": 7.579271174741542,
 *         "alertsCount": 422,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "25",
 *         "regionName": "Чернігівська область",
 *         "durationVal": "24 д. 20 год. 5 хв.",
 *         "percentage": 9.90255731002017,
 *         "alertsCount": 392,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "24",
 *         "regionName": "Черкаська область",
 *         "durationVal": "22 д. 14 год. 46 хв.",
 *         "percentage": 9.016820229540507,
 *         "alertsCount": 594,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "14",
 *         "regionName": "Київська область",
 *         "durationVal": "20 д. 3 год. 42 хв.",
 *         "percentage": 8.035389221763484,
 *         "alertsCount": 451,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "19",
 *         "regionName": "Полтавська область",
 *         "durationVal": "26 д. 14 год. 54 хв.",
 *         "percentage": 10.613877336818865,
 *         "alertsCount": 714,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "22",
 *         "regionName": "Харківська область",
 *         "durationVal": "49 д. 17 год. 23 хв.",
 *         "percentage": 19.82504040795348,
 *         "alertsCount": 1372,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "5",
 *         "regionName": "Рівненська область",
 *         "durationVal": "10 д. 21 год. 37 хв.",
 *         "percentage": 4.3462940824620135,
 *         "alertsCount": 264,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "20",
 *         "regionName": "Сумська область",
 *         "durationVal": "21 д. 22 год. 55 хв.",
 *         "percentage": 8.753539278427514,
 *         "alertsCount": 486,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "4",
 *         "regionName": "Вінницька область",
 *         "durationVal": "15 д. 23 год. 55 хв.",
 *         "percentage": 6.377932615844167,
 *         "alertsCount": 397,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "8",
 *         "regionName": "Волинська область",
 *         "durationVal": "11 д. 1 хв.",
 *         "percentage": 4.386201983929058,
 *         "alertsCount": 266,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "27",
 *         "regionName": "Львівська область",
 *         "durationVal": "9 д. 19 год. 16 хв.",
 *         "percentage": 3.908497550030114,
 *         "alertsCount": 218,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "23",
 *         "regionName": "Херсонська область",
 *         "durationVal": "11 д. 23 год. 53 хв.",
 *         "percentage": 4.782469953081017,
 *         "alertsCount": 310,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "21",
 *         "regionName": "Тернопільська область",
 *         "durationVal": "11 д. 8 год. 27 хв.",
 *         "percentage": 4.526116182789298,
 *         "alertsCount": 247,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "26",
 *         "regionName": "Чернівецька область",
 *         "durationVal": "9 д. 13 год. 11 хв.",
 *         "percentage": 3.8074253834955107,
 *         "alertsCount": 195,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "11",
 *         "regionName": "Закарпатська область",
 *         "durationVal": "8 д. 22 год. 23 хв.",
 *         "percentage": 3.561442965137588,
 *         "alertsCount": 188,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "13",
 *         "regionName": "Івано-Франківська область",
 *         "durationVal": "10 д. 2 год. 11 хв.",
 *         "percentage": 4.023233355568916,
 *         "alertsCount": 215,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "3",
 *         "regionName": "Хмельницька область",
 *         "durationVal": "10 д. 20 год. 58 хв.",
 *         "percentage": 4.335429030266298,
 *         "alertsCount": 245,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "16",
 *         "regionName": "Луганська область",
 *         "durationVal": "250 д. 19 год. 37 хв.",
 *         "percentage": 100,
 *         "alertsCount": 2,
 *         "isContinue": true
 *         },
 *         {
 *         "regionId": "9999",
 *         "regionName": "Автономна Республіка Крим",
 *         "durationVal": "22 год. 56 хв.",
 *         "percentage": 0.38102255664809803,
 *         "alertsCount": 7,
 *         "isContinue": false
 *         }
 *         ],
 *         "weekDurations": [
 *         {
 *         "regionId": "27",
 *         "regionName": "Львівська область",
 *         "durationVal": "3 год. 39 хв.",
 *         "percentage": 16.0440980987573,
 *         "alertsCount": 2,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "8",
 *         "regionName": "Волинська область",
 *         "durationVal": "4 год. 15 хв.",
 *         "percentage": 18.66486176660691,
 *         "alertsCount": 3,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "31",
 *         "regionName": "м. Київ",
 *         "durationVal": "4 год. 34 хв.",
 *         "percentage": 20.11122086854718,
 *         "alertsCount": 3,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "28",
 *         "regionName": "Донецька область",
 *         "durationVal": "22 год. 46 хв.",
 *         "percentage": 100,
 *         "alertsCount": 30,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "12",
 *         "regionName": "Запорізька область",
 *         "durationVal": "21 год. 35 хв.",
 *         "percentage": 94.7633507725704,
 *         "alertsCount": 25,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "9",
 *         "regionName": "Дніпропетровська область",
 *         "durationVal": "18 год. 2 хв.",
 *         "percentage": 79.23145404212246,
 *         "alertsCount": 22,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "23",
 *         "regionName": "Херсонська область",
 *         "durationVal": "7 год. 51 хв.",
 *         "percentage": 34.52603080525372,
 *         "alertsCount": 8,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "15",
 *         "regionName": "Кіровоградська область",
 *         "durationVal": "10 год. 50 хв.",
 *         "percentage": 47.62131245502994,
 *         "alertsCount": 6,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "17",
 *         "regionName": "Миколаївська область",
 *         "durationVal": "7 год. 33 хв.",
 *         "percentage": 33.19796582885157,
 *         "alertsCount": 6,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "22",
 *         "regionName": "Харківська область",
 *         "durationVal": "20 год. 54 хв.",
 *         "percentage": 91.82937085086404,
 *         "alertsCount": 29,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "4",
 *         "regionName": "Вінницька область",
 *         "durationVal": "4 год. 6 хв.",
 *         "percentage": 18.061195868242297,
 *         "alertsCount": 2,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "14",
 *         "regionName": "Київська область",
 *         "durationVal": "8 год. 31 хв.",
 *         "percentage": 37.440232586982766,
 *         "alertsCount": 7,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "18",
 *         "regionName": "Одеська область",
 *         "durationVal": "5 год. 39 хв.",
 *         "percentage": 24.867376431419896,
 *         "alertsCount": 4,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "11",
 *         "regionName": "Закарпатська область",
 *         "durationVal": "3 год. 41 хв.",
 *         "percentage": 16.213612361126355,
 *         "alertsCount": 2,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "3",
 *         "regionName": "Хмельницька область",
 *         "durationVal": "3 год. 44 хв.",
 *         "percentage": 16.39532189416944,
 *         "alertsCount": 2,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "26",
 *         "regionName": "Чернівецька область",
 *         "durationVal": "3 год. 41 хв.",
 *         "percentage": 16.23434432127221,
 *         "alertsCount": 2,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "20",
 *         "regionName": "Сумська область",
 *         "durationVal": "9 год. 16 хв.",
 *         "percentage": 40.728545470066706,
 *         "alertsCount": 10,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "5",
 *         "regionName": "Рівненська область",
 *         "durationVal": "4 год. 20 хв.",
 *         "percentage": 19.038037049232308,
 *         "alertsCount": 3,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "24",
 *         "regionName": "Черкаська область",
 *         "durationVal": "6 год. 29 хв.",
 *         "percentage": 28.488152294540175,
 *         "alertsCount": 4,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "13",
 *         "regionName": "Івано-Франківська область",
 *         "durationVal": "3 год. 43 хв.",
 *         "percentage": 16.32336979719265,
 *         "alertsCount": 2,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "25",
 *         "regionName": "Чернігівська область",
 *         "durationVal": "4 год. 9 хв.",
 *         "percentage": 18.2880279027793,
 *         "alertsCount": 2,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "21",
 *         "regionName": "Тернопільська область",
 *         "durationVal": "3 год. 38 хв.",
 *         "percentage": 16.018488030341835,
 *         "alertsCount": 2,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "19",
 *         "regionName": "Полтавська область",
 *         "durationVal": "13 год. 3 хв.",
 *         "percentage": 57.31167453261625,
 *         "alertsCount": 13,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "10",
 *         "regionName": "Житомирська область",
 *         "durationVal": "6 год. 4 хв.",
 *         "percentage": 26.64910547689606,
 *         "alertsCount": 3,
 *         "isContinue": false
 *         }
 *         ],
 *         "todayDurations": [
 *         {
 *         "regionId": "8",
 *         "regionName": "Волинська область",
 *         "durationVal": "35 хв.",
 *         "percentage": 20.001857182653914,
 *         "alertsCount": 1,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "5",
 *         "regionName": "Рівненська область",
 *         "durationVal": "39 хв.",
 *         "percentage": 22.174760887733306,
 *         "alertsCount": 1,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "28",
 *         "regionName": "Донецька область",
 *         "durationVal": "2 год. 59 хв.",
 *         "percentage": 100,
 *         "alertsCount": 6,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "9",
 *         "regionName": "Дніпропетровська область",
 *         "durationVal": "1 год. 45 хв.",
 *         "percentage": 58.538397251369666,
 *         "alertsCount": 3,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "22",
 *         "regionName": "Харківська область",
 *         "durationVal": "2 год. 21 хв.",
 *         "percentage": 78.7816881790324,
 *         "alertsCount": 4,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "12",
 *         "regionName": "Запорізька область",
 *         "durationVal": "1 год. 58 хв.",
 *         "percentage": 66.27356300492153,
 *         "alertsCount": 3,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "19",
 *         "regionName": "Полтавська область",
 *         "durationVal": "29 хв.",
 *         "percentage": 16.371065094252018,
 *         "alertsCount": 1,
 *         "isContinue": false
 *         },
 *         {
 *         "regionId": "20",
 *         "regionName": "Сумська область",
 *         "durationVal": "1 год. 3 хв.",
 *         "percentage": 35.314328164174945,
 *         "alertsCount": 2,
 *         "isContinue": false
 *         }
 *         ]
 *         }
 */
public class UkraineAlarm {
}
