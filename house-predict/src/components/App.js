import React from 'react';
import axios from 'axios';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Button from '@material-ui/core/Button';

export default class App extends React.Component {
  constructor() {
    super();
    this.getData(this);
  }
  handleSelect(selectedTab) {
    this.setState({
      activeTab: selectedTab,
      selectedYear: selectedTab
    });
  }
  getData(ev) {
    return axios.get('http://localhost:8080/api/house')
      .then((response) => {
        ev.setState({ data: response.data });
        this.render();
      });
  }
  getPredictedValue(row) {
    return axios.get('http://localhost:8080/api/house/predict?id=' + row.id)
      .then((response) => {
        row.predicted = response.data;
        this.forceUpdate()
      });
  }
  render() {
    if (this.state && this.state.data) {
      return (
        <div>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>ID</TableCell>
                <TableCell align="right">AGE</TableCell>
                <TableCell align="right">B</TableCell>
                <TableCell align="right">CHAS</TableCell>
                <TableCell align="right">CRIM</TableCell>
                <TableCell align="right">DIS</TableCell>
                <TableCell align="right">INDUS</TableCell>
                <TableCell align="right">LSTAT</TableCell>
                <TableCell align="right">NOX</TableCell>
                <TableCell align="right">PTRATIO</TableCell>
                <TableCell align="right">RAD</TableCell>
                <TableCell align="right">RM</TableCell>
                <TableCell align="right">TAX</TableCell>
                <TableCell align="right">ZN</TableCell>
                <TableCell align="right">MEDV</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {

                this.state.data.map(row => (
                  <TableRow key={row.name}>
                    <TableCell component="th" scope="row">
                      {row.id}
                    </TableCell>
                    <TableCell align="right">{row.age}</TableCell>
                    <TableCell align="right">{row.b}</TableCell>
                    <TableCell align="right">{row.chas}</TableCell>
                    <TableCell align="right">{row.crim}</TableCell>
                    <TableCell align="right">{row.dis}</TableCell>
                    <TableCell align="right">{row.indus}</TableCell>
                    <TableCell align="right">{row.lstat}</TableCell>
                    <TableCell align="right">{row.nox}</TableCell>
                    <TableCell align="right">{row.ptratio}</TableCell>
                    <TableCell align="right">{row.rad}</TableCell>
                    <TableCell align="right">{row.rm}</TableCell>
                    <TableCell align="right">{row.tax}</TableCell>
                    <TableCell align="right">{row.zn}</TableCell>
                    <TableCell align="right">{row.medv}</TableCell>
                    <TableCell align="right">
                    <Button variant="contained" onClick={()=>{ this.getPredictedValue(row); }}>
                      Predict
                    </Button>
                    </TableCell>
                    <TableCell align="right">{row.predicted}</TableCell>
                  </TableRow>
                ))
              }}
        </TableBody>
          </Table>
        </div>
      );
    } else {
      return (<h1>Fetching!!</h1>);
    }
  }
}