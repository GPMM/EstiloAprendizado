import React, { Component } from "react";
import { Grid, Row, Col } from "react-bootstrap";

import Card from "components/Card/Card.jsx";
import { FormInputs } from "components/FormInputs/FormInputs.jsx";
import Button from "components/CustomButton/CustomButton.jsx";

class Typography extends Component {
  render() {
    return (
      <div className="content">
        <Grid fluid>
          <Row>
            <Col md={4}>
              <Card
                content={
                  <form>
                    <FormInputs
                      ncols={["col-md-12"]}
                      properties={[
                        {
                          label: "Matrícula",
                          type: "email",
                          bsClass: "form-control",
                          placeholder: "Digite a Matrícula"
                        }
                      ]}
                    />
                    <FormInputs
                      ncols={["col-md-12"]}
                      properties={[
                        {
                          label: "Senha",
                          type: "text",
                          bsClass: "form-control",
                          placeholder: "Digite a Senha"
                        }
                      ]}
                    />
                    <div>
                      <Button bsStyle="info" fill type="submit">
                        Login
                    </Button>
                      <p className="category">
                        <a
                          target="_blank"
                          rel="noopener noreferrer"
                          href="https://github.com/igorprado"
                        ></a>
                     Cadastrar-se
                    </p>
                    </div>
                  </form>
                }
              />
            </Col>
          </Row>
        </Grid>
      </div>
    );
  }
}

export default Typography;
