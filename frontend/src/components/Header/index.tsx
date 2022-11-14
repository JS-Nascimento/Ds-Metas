import './style.css'
import logo from '../../assets/images/logo.svg'
function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={logo} alt="" />
                <h1>DS Metas</h1>
                <p>Desenvolvido por Jorge Nascimento</p>

            </div>
        </header>
    )
}

export default Header