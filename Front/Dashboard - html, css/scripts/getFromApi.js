
//GetAllExtracts(); -> FUNCIONANDO
async function GetAllExtracts() {
    try {
        const response = await fetch('http://localhost:8080/api/extract/get');
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Erro ao obter extracts: ', error);
        throw error; // Propague o erro para o chamador, se necessário
    }
}

async function GetAllUsers(userData)
{
    try
    {
        const response = await fetch('http://localhost:8080/api/user/get')
        const data = await response.json();
        return data;
    }
    catch(error)
    {
        console.error('Erro ao obter Users: ', error)
        throw error;
    }
}

