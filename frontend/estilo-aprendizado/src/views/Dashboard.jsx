import React, { Component } from "react";
import { Radar } from "react-chartjs-2";
import Chart from "react-apexcharts";
import { Grid, Row, Col } from "react-bootstrap";

import { Card } from "components/Card/Card.jsx";

var dataRadar = {
  labels: ["Ativo", "Reflexivo", "Teórico", "Pragmático"],
  datasets: [
    {
      label: "Ativo",
      backgroundColor: "rgba(0, 143, 251, 0.85)",
      borderColor: "rgba(0, 143, 251, 0.85)",
      data: [65, 59, 90, 81]
    },
    {
      label: "Reflexivo",
      backgroundColor: "rgba(255, 69, 96, 0.85)",
      borderColor: "rgba(255, 69, 96, 0.85)",
      data: [65, 59, 90, 81]
    },
    {
      label: "Teórico",
      backgroundColor: "rgba(254, 176, 25, 0.85)",
      borderColor: "rgba(254, 176, 25, 0.85)",
      data: [65, 59, 90, 81]
    },
    {
      label: "Pragmático",
      backgroundColor: "rgba(0, 227, 150, 0.85)",
      borderColor: "rgba(0, 227, 150, 0.85)",
      data: [28, 48, 40, 19]
    }
  ]
};

var stateChart = {

  series: [
    {
      name: "Ativo",
      data: [0, 1, 2, 3]
    },
    {
      name: "Pragmático",
      data: [0, 1, 2, 3]
    },
    {
      name: "Teórico",
      data: [0, 1, 2, 3]
    },
    {
      name: "Reflexivo",
      data: [0, 1, 2, 3]
    }
  ],
  options: {
    chart: {
      type: 'bar',
      height: 430
    },
    plotOptions: {
      bar: {
        horizontal: true,
        dataLabels: {
          position: 'top',
        },
      }
    },
    dataLabels: {
      enabled: true,
      offsetX: -6,
      style: {
        fontSize: '12px',
        colors: ['#fff']
      }
    },
    stroke: {
      show: true,
      width: 1,
      colors: ['#fff']
    },
    xaxis: {
      categories: ["Muito Baixa", "Baixa", "Moderada", "Alta", "Muito Alta"],
    },
  },
};

class Dashboard extends Component {
  createLegend(json) {
    var legend = [];
    for (var i = 0; i < json["names"].length; i++) {
      var type = "fa fa-circle text-" + json["types"][i];
      legend.push(<i className={type} key={i} />);
      legend.push(" ");
      legend.push(json["names"][i]);
    }
    return legend;
  }

  render() {
    return (
      <div className="content">

        <Grid fluid>
          <Row>
            <Col md={8}>
              <Card
                title="Resumo da turma"
                content={
                  <div
                    id="chartPreferences"
                    className="ct-chart ct-perfect-fourth"
                  >
                    <Chart
                      options={stateChart.options} series={stateChart.series} type="bar"
                    />
                  </div>
                }
              />
            </Col>
          </Row>
          <Row>
          <Col md={8}>
              <Card
                title="Níveis da turma"
                content={
                  <div
                    id="chartPreferences"
                    className="ct-chart ct-perfect-fourth"
                  >
                    <Radar data={dataRadar} type="radar" />
                  </div>
                }

              />

            </Col>
          </Row>
        </Grid>
      </div>
    );
  }
}

export default Dashboard;
