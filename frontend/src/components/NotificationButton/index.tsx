import axios from 'axios';
import notification from '../../assets/images/notification-icon.svg'
import { BASE_URL } from '../../utils/request';
import './style.css'

type Props ={
    saleId: number;
}

function handleClick(id :number){
    axios(`${BASE_URL}/sales/${id}/notification`)
            .then(response => {
                alert("Sucesso")
            })
}

function NotificationButton({saleId} : Props){
    return(
        <div className="dsmeta-red-btn" onClick={()=> handleClick(saleId)}>
            <img src={notification} alt="Notification" />
        </div>
    )
}

export default NotificationButton