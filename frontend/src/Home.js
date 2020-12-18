import React, { Component, useState, useEffect } from 'react';

function Home() {
    const [taskname, setTaskname] = useState("");
    const [task, setTask] = useState("");
    const [description, setDescription] = useState("");
    const [solutionCode, setSolutionCode] = useState("");

    const [result, setResult] = useState("");
    const [error, setError] = useState(false);

    useEffect(() => {
        fetch('/api/gettasks')
            .then(response => response.text())
            .then(res => {
            });
    }, []);

    const handleSubmit = async () => {
        await fetch('/api/submittask', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                username: taskname,
                selectedtask: task,
                description: description,
                solution: solutionCode
            }),
        }).then(
            (response) => {
                if (response.ok) {
                    setError(false)
                } else {
                    setError(true);
                }
            },
            (error) => {
                setError(true);
            }
        );
    }

    return (

        <div>
            <h1>{result}</h1>
            {error && '<h1>Error occurred</h1>'}
            <h1>Submit solution in Java</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    Name :
                    <input type="text" onChange={e => {
                        setTaskname(e.target.value);
                    }} />
                </label>
                <br />
                <label>
                    Select Task :
                    <select value={task}
                        onChange={e => {
                            console.log(e.target.value)
                            setTask(e.target.value)
                        }}>
                        <option value="select">Select</option>
                        <option value="Fibonacci">Fibonacci</option>
                        <option value="Tower of Hanoi">Tower of Hanoi</option>
                        <option value="Card problem">Card problem</option>
                    </select>
                </label>
                <br />
                <label>
                    Description :
                    <input type="text" onChange={e => {
                        setDescription(e.target.value);
                    }} />
                </label>
                <br />
                <textarea onChange={e => {
                    setSolutionCode(e.target.value);
                }}>
                    {solutionCode}
                </textarea>
                &nbsp;
                <br />
                <input type="button" value="Submit" id="myBtn" onClick={handleSubmit} />
            </form>
        </div>
    )
}

export default Home;
