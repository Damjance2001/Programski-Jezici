-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 07, 2024 at 06:59 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `turisticka_agencija`
--

-- --------------------------------------------------------

--
-- Table structure for table `klijent`
--

CREATE TABLE `klijent` (
  `id` int(11) NOT NULL,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `kontakt_informacije` varchar(255) NOT NULL,
  `istorija_rezervacije` longtext DEFAULT NULL,
  `rezervacija_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `klijent`
--

INSERT INTO `klijent` (`id`, `ime`, `prezime`, `kontakt_informacije`, `istorija_rezervacije`, `rezervacija_id`) VALUES
(1, 'Pera', 'Peric', 'informacije', 'Rezervacija{klijent=Klijent{id=1, ime=\'Pera\', prezime=\'Peric\', kontaktInformacije=\'informacije\', istorijaRezervacije=\'Rezervacija{klijent=Klijent{id=1, ime=\'Pera\', prezime=\'Peric\', kontaktInformacije=\'informacije\', istorijaRezervacije=\'istorija\', rezervacija=null}, turistickiPaket=TuristickiPaket{id=2, destinacija=\'Andaluzija\', opis=\'Београд је главни и најнасељенији град Србије. Лежи на ушћу Саве у Дунав, где се Панонска низија спаја са Балканским полуострвом. Београд је управно средиште града Београда, посебне територијалне јединице са својом месном самоуправом. По броју становника четврти је у југоисточној Европи после Истанбула, Атине и Букурешта. \', datumPutovanja=null, cena=40.99, statusDostupnosti=false}, datumRezervacije=2024-09-05 00:00:00.0, statusRezervacije=true}\'}, turistickiPaket=TuristickiPaket{id=1, destinacija=\'Kragujevac\', opis=\'Крагујевац је градско насеље и седиште истоимене територијалне јединице у Србији. Административни је центар Шумадијског управног округа и највећи град Шумадије и западне Србије. Према попису из 2022. било је 146.315 становника, што га чини четвртим насељем по броју становника у Србији.[2] Смештен је у географском средишту земље, 145 km јужно од Београда. Од 1818. до 1841. био је престоница српске државе. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-03 00:00:00.0, statusRezervacije=true}', 0),
(2, 'Zika', 'Zikic', 'kontakt', 'Rezervacija{klijent=Klijent{id=2, ime=\'Zika\', prezime=\'Zikic\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'istorijaRezervacije\', rezervacija=null}, turistickiPaket=TuristickiPaket{id=1, destinacija=\'Kragujevac\', opis=\'Крагујевац је градско насеље и седиште истоимене територијалне јединице у Србији. Административни је центар Шумадијског управног округа и највећи град Шумадије и западне Србије. Према попису из 2022. било је 146.315 становника, што га чини четвртим насељем по броју становника у Србији.[2] Смештен је у географском средишту земље, 145 km јужно од Београда. Од 1818. до 1841. био је престоница српске државе. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-03 00:00:00.0, statusRezervacije=true};\n-;\nRezervacija{klijent=Klijent{id=2, ime=\'Zika\', prezime=\'Zikic\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'Rezervacija{klijent=Klijent{id=2, ime=\'Zika\', prezime=\'Zikic\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'istorijaRezervacije\', rezervacija=null}, turistickiPaket=TuristickiPaket{id=1, destinacija=\'Kragujevac\', opis=\'Крагујевац је градско насеље и седиште истоимене територијалне јединице у Србији. Административни је центар Шумадијског управног округа и највећи град Шумадије и западне Србије. Према попису из 2022. било је 146.315 становника, што га чини четвртим насељем по броју становника у Србији.[2] Смештен је у географском средишту земље, 145 km јужно од Београда. Од 1818. до 1841. био је престоница српске државе. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-03 00:00:00.0, statusRezervacije=true}\'}, turistickiPaket=TuristickiPaket{id=1, destinacija=\'Kragujevac\', opis=\'Крагујевац је градско насеље и седиште истоимене територијалне јединице у Србији. Административни је центар Шумадијског управног округа и највећи град Шумадије и западне Србије. Према попису из 2022. било је 146.315 становника, што га чини четвртим насељем по броју становника у Србији.[2] Смештен је у географском средишту земље, 145 km јужно од Београда. Од 1818. до 1841. био је престоница српске државе. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-03 00:00:00.0, statusRezervacije=true}', NULL),
(3, 'Zika', 'Zikic', 'kontakt', 'Rezervacija{klijent=Klijent{id=3, ime=\'Zika\', prezime=\'Zikic\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'null\', rezervacija=null}, turistickiPaket=TuristickiPaket{id=2, destinacija=\'Andaluzija\', opis=\'Београд је главни и најнасељенији град Србије. Лежи на ушћу Саве у Дунав, где се Панонска низија спаја са Балканским полуострвом. Београд је управно средиште града Београда, посебне територијалне јединице са својом месном самоуправом. По броју становника четврти је у југоисточној Европи после Истанбула, Атине и Букурешта. \', datumPutovanja=null, cena=40.99, statusDostupnosti=false}, datumRezervacije=2024-09-03 00:00:00.0, statusRezervacije=true}', NULL),
(4, 'Nikola', 'Nikolic', 'kontakt', 'null;-;Rezervacija{klijent=Klijent{id=4, ime=\'Nikola\', prezime=\'Nikolic\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'null\'}, turistickiPaket=TuristickiPaket{id=2, destinacija=\'Beograd\', opis=\'Београд је главни и најнасељенији град Србије. Лежи на ушћу Саве у Дунав, где се Панонска низија спаја са Балканским полуострвом. Београд је управно средиште града Београда, посебне територијалне јединице са својом месном самоуправом. По броју становника четврти је у југоисточној Европи после Истанбула, Атине и Букурешта. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-05 00:00:00.0, statusRezervacije=true};-;Rezervacija{klijent=Klijent{id=4, ime=\'Nikola\', prezime=\'Nikolic\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'null;-;Rezervacija{klijent=Klijent{id=4, ime=\'Nikola\', prezime=\'Nikolic\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'null\'}, turistickiPaket=TuristickiPaket{id=2, destinacija=\'Beograd\', opis=\'Београд је главни и најнасељенији град Србије. Лежи на ушћу Саве у Дунав, где се Панонска низија спаја са Балканским полуострвом. Београд је управно средиште града Београда, посебне територијалне јединице са својом месном самоуправом. По броју становника четврти је у југоисточној Европи после Истанбула, Атине и Букурешта. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-05 00:00:00.0, statusRezervacije=true}\'}, turistickiPaket=TuristickiPaket{id=2, destinacija=\'Beograd\', opis=\'Београд је главни и најнасељенији град Србије. Лежи на ушћу Саве у Дунав, где се Панонска низија спаја са Балканским полуострвом. Београд је управно средиште града Београда, посебне територијалне јединице са својом месном самоуправом. По броју становника четврти је у југоисточној Европи после Истанбула, Атине и Букурешта. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-05 00:00:00.0, statusRezervacije=true};\n-;\nRezervacija{klijent=Klijent{id=4, ime=\'Nikola\', prezime=\'Nikolic\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'null;-;Rezervacija{klijent=Klijent{id=4, ime=\'Nikola\', prezime=\'Nikolic\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'null\'}, turistickiPaket=TuristickiPaket{id=2, destinacija=\'Beograd\', opis=\'Београд је главни и најнасељенији град Србије. Лежи на ушћу Саве у Дунав, где се Панонска низија спаја са Балканским полуострвом. Београд је управно средиште града Београда, посебне територијалне јединице са својом месном самоуправом. По броју становника четврти је у југоисточној Европи после Истанбула, Атине и Букурешта. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-05 00:00:00.0, statusRezervacije=true};-;Rezervacija{klijent=Klijent{id=4, ime=\'Nikola\', prezime=\'Nikolic\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'null;-;Rezervacija{klijent=Klijent{id=4, ime=\'Nikola\', prezime=\'Nikolic\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'null\'}, turistickiPaket=TuristickiPaket{id=2, destinacija=\'Beograd\', opis=\'Београд је главни и најнасељенији град Србије. Лежи на ушћу Саве у Дунав, где се Панонска низија спаја са Балканским полуострвом. Београд је управно средиште града Београда, посебне територијалне јединице са својом месном самоуправом. По броју становника четврти је у југоисточној Европи после Истанбула, Атине и Букурешта. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-05 00:00:00.0, statusRezervacije=true}\'}, turistickiPaket=TuristickiPaket{id=2, destinacija=\'Beograd\', opis=\'Београд је главни и најнасељенији град Србије. Лежи на ушћу Саве у Дунав, где се Панонска низија спаја са Балканским полуострвом. Београд је управно средиште града Београда, посебне територијалне јединице са својом месном самоуправом. По броју становника четврти је у југоисточној Европи после Истанбула, Атине и Букурешта. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-05 00:00:00.0, statusRezervacije=true}\'}, turistickiPaket=TuristickiPaket{id=2, destinacija=\'Beograd\', opis=\'Београд је главни и најнасељенији град Србије. Лежи на ушћу Саве у Дунав, где се Панонска низија спаја са Балканским полуострвом. Београд је управно средиште града Београда, посебне територијалне јединице са својом месном самоуправом. По броју становника четврти је у југоисточној Европи после Истанбула, Атине и Букурешта. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-05 00:00:00.0, statusRezervacije=true}', NULL),
(5, 'Pera', 'Peric', 'kontakt', 'null;\n-;\nRezervacija{klijent=Klijent{id=5, ime=\'Pera\', prezime=\'Peric\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'null\'}, turistickiPaket=TuristickiPaket{id=2, destinacija=\'Beograd\', opis=\'Београд је главни и најнасељенији град Србије. Лежи на ушћу Саве у Дунав, где се Панонска низија спаја са Балканским полуострвом. Београд је управно средиште града Београда, посебне територијалне јединице са својом месном самоуправом. По броју становника четврти је у југоисточној Европи после Истанбула, Атине и Букурешта. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-05 00:00:00.0, statusRezervacije=true}', NULL),
(6, 'Pera', 'Peric', 'kontakt', '- null;\n- Rezervacija{klijent=Klijent{id=6, ime=\'Pera\', prezime=\'Peric\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'- null\'}, turistickiPaket=TuristickiPaket{id=1, destinacija=\'Kragujevac\', opis=\'Крагујевац је градско насеље и седиште истоимене територијалне јединице у Србији. Административни је центар Шумадијског управног округа и највећи град Шумадије и западне Србије. Према попису из 2022. било је 146.315 становника, што га чини четвртим насељем по броју становника у Србији.[2] Смештен је у географском средишту земље, 145 km јужно од Београда. Од 1818. до 1841. био је престоница српске државе. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-03 00:00:00.0, statusRezervacije=true};\n- Rezervacija{klijent=Klijent{id=6, ime=\'Pera\', prezime=\'Peric\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'- null;\n- Rezervacija{klijent=Klijent{id=6, ime=\'Pera\', prezime=\'Peric\', kontaktInformacije=\'kontakt\', istorijaRezervacije=\'- null\'}, turistickiPaket=TuristickiPaket{id=1, destinacija=\'Kragujevac\', opis=\'Крагујевац је градско насеље и седиште истоимене територијалне јединице у Србији. Административни је центар Шумадијског управног округа и највећи град Шумадије и западне Србије. Према попису из 2022. било је 146.315 становника, што га чини четвртим насељем по броју становника у Србији.[2] Смештен је у географском средишту земље, 145 km јужно од Београда. Од 1818. до 1841. био је престоница српске државе. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-03 00:00:00.0, statusRezervacije=true}\'}, turistickiPaket=TuristickiPaket{id=1, destinacija=\'Kragujevac\', opis=\'Крагујевац је градско насеље и седиште истоимене територијалне јединице у Србији. Административни је центар Шумадијског управног округа и највећи град Шумадије и западне Србије. Према попису из 2022. било је 146.315 становника, што га чини четвртим насељем по броју становника у Србији.[2] Смештен је у географском средишту земље, 145 km јужно од Београда. Од 1818. до 1841. био је престоница српске државе. \', datumPutovanja=null, cena=40.99, statusDostupnosti=true}, datumRezervacije=2024-09-03 00:00:00.0, statusRezervacije=true}', NULL),
(7, 'Pera', 'Peric', 'informacije', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
  `id` int(11) NOT NULL,
  `klijent_id` int(11) DEFAULT NULL,
  `turisticki_paket_id` int(11) DEFAULT NULL,
  `datum_rezervacije` date DEFAULT NULL,
  `status_rezervacije` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`id`, `klijent_id`, `turisticki_paket_id`, `datum_rezervacije`, `status_rezervacije`) VALUES
(1, 5, 2, '2024-09-05', 1),
(2, 6, 1, '2024-09-03', 1),
(3, 3, 2, '2024-09-03', 1),
(4, NULL, NULL, '2024-09-09', 1),
(5, NULL, 4, '2024-09-03', 1),
(6, NULL, 3, '2024-09-03', 1),
(7, NULL, NULL, NULL, 0),
(8, NULL, NULL, NULL, 0),
(9, NULL, 6, NULL, 0),
(10, 7, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `specijalna_ponuda`
--

CREATE TABLE `specijalna_ponuda` (
  `id` int(11) NOT NULL,
  `turisticki_paket_id` int(11) DEFAULT NULL,
  `opis` varchar(255) NOT NULL,
  `popust` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `turisticki_paket`
--

CREATE TABLE `turisticki_paket` (
  `id` int(11) NOT NULL,
  `destinacija` varchar(255) NOT NULL,
  `opis` text NOT NULL,
  `cena` decimal(12,2) NOT NULL,
  `status_dostupnosti` tinyint(1) NOT NULL,
  `rezervacija_id` int(11) DEFAULT NULL,
  `datum_putovanja` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `turisticki_paket`
--

INSERT INTO `turisticki_paket` (`id`, `destinacija`, `opis`, `cena`, `status_dostupnosti`, `rezervacija_id`, `datum_putovanja`) VALUES
(1, 'Kragujevac', 'Крагујевац је градско насеље и седиште истоимене територијалне јединице у Србији. Административни је центар Шумадијског управног округа и највећи град Шумадије и западне Србије. Према попису из 2022. било је 146.315 становника, што га чини четвртим насељем по броју становника у Србији.[2] Смештен је у географском средишту земље, 145 km јужно од Београда. Од 1818. до 1841. био је престоница српске државе. ', 3.29, 1, 1, '2024-03-08'),
(2, 'Beograd', 'Београд је главни и најнасељенији град Србије. Лежи на ушћу Саве у Дунав, где се Панонска низија спаја са Балканским полуострвом. Београд је управно средиште града Београда, посебне територијалне јединице са својом месном самоуправом. По броју становника четврти је у југоисточној Европи после Истанбула, Атине и Букурешта.', 35.73, 1, 1, '2024-03-08'),
(6, 'Andaluzija', 'Андалузија (шп. Andalucía) је најјужнија континенална аутономна заједница Краљевине Шпаније. Најпопуларнија је и друга по величини аутономна заједница у Шпанији.аутономна заједница Андалузија је званично призната као једна од шпанских националности. Територија је подељена на осам покрајина: Алмерија, Кадиз, Кордоба, Гранада, Уелва, Хаен, Малага и Севиља. Главни град покрајине је Севиља.', 20.25, 1, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `klijent`
--
ALTER TABLE `klijent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `specijalna_ponuda`
--
ALTER TABLE `specijalna_ponuda`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `turisticki_paket`
--
ALTER TABLE `turisticki_paket`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `klijent`
--
ALTER TABLE `klijent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `rezervacija`
--
ALTER TABLE `rezervacija`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `specijalna_ponuda`
--
ALTER TABLE `specijalna_ponuda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `turisticki_paket`
--
ALTER TABLE `turisticki_paket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
