import React, { Component, useState, useEffect } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';

const useStyles = makeStyles({
    table: {
        minWidth: 650,
    },
});

function Top() {
    const [message, setMessage] = useState();

    useEffect((message) => {
        fetch('/api/gettop3')
            .then(response => response.json())
            .then(res => {
                console.log(res)
                setMessage(res)
            });
    }, [])

    return (
        <div>

            <TableContainer>
                <Table aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>Name</TableCell>
                            <TableCell align="right">Task_name</TableCell>
                            <TableCell align="right">solution</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {message && message.map((row) => (
                            <TableRow key={row.id}>
                                <TableCell component="th" scope="row">
                                    {row.userName}
                                </TableCell>
                                <TableCell align="right">{row.task_name}</TableCell>
                                <TableCell align="right">{row.solution}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>

        </div >
    )
}

export default Top;
