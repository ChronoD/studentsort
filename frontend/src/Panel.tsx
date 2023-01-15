import { FormEvent, useEffect, useState } from "react";

export function Panel() {
  const [resp, setResp] = useState("loading");

  const [selectedFile, setSelectedFile] = useState<string | Blob>("");

  const [isFilePicked, setIsSelected] = useState<boolean>(false);

  useEffect(() => {
    fetch("http://localhost:8080/api-v1/sort")
      .then((response) => response.text())
      .then((data) => setResp(data));
  }, []);

  function postForSorting(e: FormEvent) {
    const formData = new FormData();

    formData.append("file", selectedFile);

    fetch("http://localhost:8080/api-v1/sort/a", {
      method: "POST",
      body: formData,
    })
      .then((response) => response.json())
      .then((result) => {
        console.log("Success:", result);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  }

  function changeHandler(event: React.ChangeEvent<HTMLInputElement>) {
    if (event.target.files !== null) {
      setSelectedFile(event.target.files[0]);
    }
    setIsSelected(true);
  }

  return (
    <div>
      <header>
        <p>hello user</p>
      </header>

      <p>
        <label htmlFor="file_input">
          Choose a .txt file of student grades (student name and student grade
          separated by comma, students separated by new line)
        </label>
      </p>

      <input
        id="file_input"
        type="file"
        name="file"
        accept=".txt"
        onChange={changeHandler}
      ></input>
      <p>
        <button onClick={postForSorting}>Submit for sorting</button>
      </p>
      <br></br>
      <p>{resp}</p>
    </div>
  );
}
