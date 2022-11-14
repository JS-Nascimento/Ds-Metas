import notification from '../../assets/images/notification-icon.svg'
import './style.css'

function NotificationButton(){
    return(
        <div className="dsmeta-red-btn">
            <img src={notification} alt="Notification" />
        </div>
    )
}

export default NotificationButton