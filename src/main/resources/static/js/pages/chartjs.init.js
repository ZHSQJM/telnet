!
    function(e) {
        "use strict";
        var r = function() {};
        r.prototype.respChart = function(r, a, o, t) {
            var n = r.get(0).getContext("2d"),
                s = e(r).parent();
            function i() {
                r.attr("width", e(s).width());
                switch (a) {
                    case "Line":
                        new Chart(n, {
                            type: "line",
                            data: o,
                            options: t
                        });
                        break;
                    case "Doughnut":
                        new Chart(n, {
                            type: "doughnut",
                            data: o,
                            options: t
                        });
                        break;
                    case "Pie":
                        new Chart(n, {
                            type: "pie",
                            data: o,
                            options: t
                        });
                        break;
                    case "Bar":
                        new Chart(n, {
                            type: "bar",
                            data: o,
                            options: t
                        });
                        break;
                    case "Radar":
                        new Chart(n, {
                            type: "radar",
                            data: o,
                            options: t
                        });
                        break;
                    case "PolarArea":
                        new Chart(n, {
                            data: o,
                            type: "polarArea",
                            options: t
                        })
                }
            }
            e(window).resize(i),
                i()
        },
            r.prototype.init = function() {
                this.respChart(e("#lineChart"), "Line", {
                        labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October"],
                        datasets: [{
                            label: "Conversion Rate",
                            fill: !1,
                            backgroundColor: "#25b343",
                            borderColor: "#25b343",
                            data: [44, 60, -33, 58, -4, 57, -89, 60, -33, 58]
                        },
                            {
                                label: "Average Sale Value",
                                fill: !1,
                                backgroundColor: "#e3eaef",
                                borderColor: "#e3eaef",
                                borderDash: [5, 5],
                                data: [ - 68, 41, 86, -49, 2, 65, -64, 86, -49, 2]
                            }]
                    },
                    {
                        responsive: !0,
                        tooltips: {
                            mode: "index",
                            intersect: !1
                        },
                        hover: {
                            mode: "nearest",
                            intersect: !0
                        },
                        scales: {
                            xAxes: [{
                                display: !0,
                                gridLines: {
                                    color: "rgba(0,0,0,0.1)"
                                }
                            }],
                            yAxes: [{
                                gridLines: {
                                    color: "rgba(255,255,255,0.05)",
                                    fontColor: "#fff"
                                },
                                ticks: {
                                    max: 100,
                                    min: -100,
                                    stepSize: 20
                                }
                            }]
                        }
                    });
                this.respChart(e("#doughnut"), "Doughnut", {
                        labels: ["Bitcoin", "Ethereum", "Cardano"],
                        datasets: [{
                            data: [80, 50, 100],
                            backgroundColor: ["#02a8b5", "#fd7e14", "#e3eaef"],
                            hoverBackgroundColor: ["#02a8b5", "#fd7e14", "#e3eaef"],
                            borderWidth: 3,
                            hoverBorderColor: "#fff"
                        }]
                    },
                    {
                        cutoutPercentage: 80
                    });
                this.respChart(e("#pie"), "Pie", {
                    labels: ["Desktops", "Tablets", "Mobiles"],
                    datasets: [{
                        data: [100, 121, 77],
                        backgroundColor: ["#d33319", "#675aa9", "#e3eaef"],
                        hoverBackgroundColor: ["#d33319", "#675aa9", "#e3eaef"],
                        hoverBorderColor: "#fff"
                    }]
                });
                this.respChart(e("#bar"), "Bar", {
                        labels: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15"],
                        datasets: [{
                            label: "Sales Analytics",
                            backgroundColor: "#4b88e4",
                            borderColor: "#4b88e4",
                            borderWidth: 1,
                            hoverBackgroundColor: "#675aa9",
                            hoverBorderColor: "#675aa9",
                            data: [65, 59, 80, 81, 56, 89, 40, 32, 65, 59, 80, 81, 56, 89, 40, 32, 65, 59, 80, 81, 56, 89, 40, 32, 65, 59, 80, 81, 56, 89, 40]
                        }]
                    },
                    {
                        legend: {
                            display: !1
                        },
                        scales: {
                            yAxes: [{
                                gridLines: {
                                    display: !1
                                },
                                ticks: {
                                    max: 100,
                                    min: 20,
                                    stepSize: 20
                                }
                            }],
                            xAxes: [{
                                barPercentage: .3,
                                gridLines: {
                                    color: "rgba(0,0,0,0.05)"
                                }
                            }]
                        }
                    });
                this.respChart(e("#radar"), "Radar", {
                    labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
                    datasets: [{
                        label: "Desktops",
                        backgroundColor: "rgba(179,181,198,0.2)",
                        borderColor: "rgba(179,181,198,1)",
                        pointBackgroundColor: "rgba(179,181,198,1)",
                        pointBorderColor: "#fff",
                        pointHoverBackgroundColor: "#fff",
                        pointHoverBorderColor: "rgba(179,181,198,1)",
                        data: [65, 59, 90, 81, 56, 55, 40]
                    },
                        {
                            label: "Tablets",
                            backgroundColor: "rgba(255,99,132,0.2)",
                            borderColor: "rgba(255,99,132,1)",
                            pointBackgroundColor: "rgba(255,99,132,1)",
                            pointBorderColor: "#fff",
                            pointHoverBackgroundColor: "#fff",
                            pointHoverBorderColor: "rgba(255,99,132,1)",
                            data: [28, 48, 40, 19, 96, 27, 100]
                        }]
                });
                this.respChart(e("#polarArea"), "PolarArea", {
                    datasets: [{
                        data: [11, 16, 7, 18],
                        backgroundColor: ["#297ef6", "#45bbe0", "#ebeff2", "#1ea69a"],
                        label: "My dataset",
                        hoverBorderColor: "#fff"
                    }],
                    labels: ["Series 1", "Series 2", "Series 3", "Series 4"]
                })
            },
            e.ChartJs = new r,
            e.ChartJs.Constructor = r
    } (window.jQuery),
    function(e) {
        "use strict";
        e.ChartJs.init()
    } (window.jQuery);