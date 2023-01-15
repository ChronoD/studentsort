import { useEffect, useState } from "react";

export function Panel() {
  const [resp, setResp] = useState("loading");

  useEffect(() => {
    fetch("http://localhost:8080/api-v1/sort")
      .then((response) => response.text())
      .then((data) => setResp(data));
  }, []);

  return (
    <div>
      <header>
        <p>hello user</p>
        <p>{resp}</p>
      </header>
    </div>
  );
}
