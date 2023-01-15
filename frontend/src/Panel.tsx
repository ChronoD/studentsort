import { FormEvent, useState } from "react";
import {
  Paper,
  TableContainer,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
  Radio,
  RadioGroup,
  FormControlLabel,
  FormControl,
  FormLabel,
  Button,
} from "@mui/material";

interface SortResult {
  students: { name: string; grade: number }[];
  sortingMethod: string;
  timeElapsed: number;
  sortedFile: File;
}

export function Panel() {
  const [file, setFile] = useState<string | Blob>("");
  const [isFileSelected, setIsFileSelected] = useState<boolean>(false);

  const [sortMethod, setSortMethod] = useState("b");

  const [response, setResponse] = useState<SortResult | undefined>();
  const [responseError, setResponseError] = useState<Error | undefined>();

  function handleFileChange(event: React.ChangeEvent<HTMLInputElement>) {
    setResponseError(undefined);
    if (event.target.files !== null) {
      setFile(event.target.files[0]);
      setIsFileSelected(true);
    } else {
      setFile("");
      setIsFileSelected(false);
    }
  }

  const handleSortMethodChange = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    setSortMethod((event.target as HTMLInputElement).value);
  };

  function postForSorting(e: FormEvent) {
    setResponseError(undefined);

    const formData = new FormData();
    formData.append("file", file);
    formData.append("method", sortMethod);

    fetch("http://localhost:8080/api-v1/sort", {
      method: "POST",
      body: formData,
    })
      .then((response) => response.json())
      .then((result) => {
        setResponse(result);
      })
      .catch((error) => {
        console.error("Error:", error);
        setResponseError(error);
      });
  }

  function downloadSortedData() {
    const sortedFileString: string | undefined = response?.students
      .map((s) => s.name + "," + s.grade)
      .join("\n");
    const content = `data:text/csv;charset=utf-8,${sortedFileString}`;
    const encodedURI = encodeURI(content);
    window.open(encodedURI);
  }

  return (
    <div
      style={{
        margin: "20vh 0",
        width: "30rem",
      }}
    >
      <header
        style={{ color: "green", fontSize: "2rem", marginBottom: "10vh" }}
      >
        Sort students by grades with different algorithms NOW!!!
      </header>
      <FormControl>
        <FormLabel id="demo-radio-buttons-group-label">
          Choose a .txt file of student grades (student name and student grade
          separated by comma, students separated by new line):{" "}
        </FormLabel>

        <div style={{ margin: "2vh 0" }}>
          <input
            id="file_input"
            type="file"
            name="file"
            accept=".txt"
            onChange={handleFileChange}
          />
        </div>
      </FormControl>
      <FormControl>
        <FormLabel id="demo-radio-buttons-group-label">
          Sorting method
        </FormLabel>
        <RadioGroup
          aria-labelledby="demo-radio-buttons-group-label"
          defaultValue="female"
          name="radio-buttons-group"
          value={sortMethod}
          onChange={handleSortMethodChange}
        >
          <FormControlLabel value="b" control={<Radio />} label="Bubble sort" />
          <FormControlLabel value="h" control={<Radio />} label="Heap sort" />
          <FormControlLabel value="m" control={<Radio />} label="Merge sort" />
        </RadioGroup>
      </FormControl>
      {isFileSelected && (
        <p>
          <Button variant="contained" disableRipple onClick={postForSorting}>
            Submit for sorting
          </Button>
        </p>
      )}
      <br></br>
      {response && (
        <div>
          <div>
            <p>
              Total students: <b>{response?.students.length}</b>
            </p>
            <p>
              Sorting method: <b>{response?.sortingMethod}</b>
            </p>
            <p>
              Time taken: <b>{response?.timeElapsed}</b>
            </p>
          </div>
          <Button disableRipple onClick={downloadSortedData}>
            download sorted file
          </Button>
          <div
            style={{
              display: "flex",
              justifyContent: "center",
            }}
          >
            <TableContainer component={Paper}>
              <Table aria-label="simple table">
                <TableHead>
                  <TableRow>
                    <TableCell>Name</TableCell>
                    <TableCell align="right">Grade</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {response.students.map((s) => (
                    <TableRow
                      key={s.name}
                      sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                    >
                      <TableCell component="th" scope="row">
                        {s.name}
                      </TableCell>
                      <TableCell align="right">{s.grade}</TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </TableContainer>
          </div>
        </div>
      )}
      {responseError && <p>Something went wrong. {responseError.message}</p>}
    </div>
  );
}
